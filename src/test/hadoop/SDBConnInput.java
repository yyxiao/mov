package hadoop; /**
 * SDBConnInput
 * <p>
 * PACKAGE_NAME
 *
 * @author xiaoyy
 *         2016-12-29 下午4:20
 *         The word 'impossible' is not in my dictionary.
 */
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.lib.db.*;
import java.sql.*;
import java.io.*;
import java.util.*;

import org.apache.hadoop.mapred.*;
import org.apache.hadoop.fs.Path;


/**
 * SDBConnInput
 * 从关系型数据库读取到HDFS
 * @author Xender
 * @Date 16/12/30 上午9:25
 * The word 'impossible' is not in my dictionary.
 */
public class SDBConnInput {
    public static class CustomerRecord implements Writable,DBWritable{
        String customerID;
        String customerName;
        String phoneNumber;
        public void readFields(ResultSet resultSet)  throws SQLException{
            customerID=resultSet.getString(1);
            customerName=resultSet.getString(2);
            phoneNumber=resultSet.getString(3);
        }
        public void write(PreparedStatement statement)  throws SQLException{
            statement.setString(1, customerID);
            statement.setString(2, customerName);
            statement.setString(3,phoneNumber);
        }

        public void readFields(DataInput in) throws IOException{
            customerID=in.readUTF();
            customerName=in.readUTF();
            phoneNumber=in.readUTF();
        }
        public void write(DataOutput out) throws IOException{
            out.writeUTF(customerID);
            out.writeUTF(customerName);
            out.writeUTF(phoneNumber);
        }
        public void setCustomerID(String customerID){
            this.customerID=customerID;
        }
        public void setCustomerName(String customerName){
            this.customerName=customerName;
        }
        public void setPhoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
        }
        public String toString(){
            return this.customerID+","+this.customerName+","+this.phoneNumber;
        }
    }
    public static class MapperClass extends MapReduceBase implements Mapper<LongWritable,CustomerRecord,LongWritable,Text>{
        Text result= new Text();
        public void map(LongWritable key, CustomerRecord value,OutputCollector<LongWritable, Text> collector, Reporter reporter) throws IOException{
            result.set(value.toString());
            collector.collect(key, result);
        }
    }
    public static class ReducerClass extends MapReduceBase implements Reducer<LongWritable, Text,NullWritable,Text>{
        public void reduce(LongWritable key, Iterator<Text> values, OutputCollector<NullWritable,Text> output, Reporter reporter) throws IOException{
            String str="";
            while(values.hasNext()){
                str+=values.next().toString();
            }
            output.collect(null, new Text(str));
        }
    }
    public static void main(String [] args) throws Exception{
        /**
         * 从关系数据库读取数据到HDFS
         */
        JobConf job = new JobConf();
        job.setJarByClass(SDBConnInput.class);
        job.setOutputKeyClass(LongWritable.class);
        job.setOutputValueClass(Text.class);
        job.setInputFormat(DBInputFormat.class);
        FileOutputFormat.setOutputPath(job, new Path("hdfs://master:9000/user/xuyizhen/out"));
        DBConfiguration.configureDB(job, "com.mysql.jdbc.Driver",
                "jdbc:mysql://192.168.0.25:3306/hadoop","root","1117");
        String fieldNames []={"customerID","customerName","phoneNumber"};
        DBInputFormat.setInput(job, CustomerRecord.class,"customers",null,"customerID", fieldNames);
        job.setMapperClass(MapperClass.class);
        job.setReducerClass(ReducerClass.class);
        JobClient.runJob(job);
    }
}