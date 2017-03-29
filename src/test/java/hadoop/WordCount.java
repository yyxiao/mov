package hadoop;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * WordCount
 * hadoop
 *
 * @author xiaoyy
 * @Date 2017-01-04 上午9:36
 *         The word 'impossible' is not in my dictionary.
 */
public class WordCount {


    /**
     * count map
     * @author Xender
     * @Date 17/1/4 上午10:25
     * The word 'impossible' is not in my dictionary.
     */
    public static class WordCountMapper extends MapReduceBase implements Mapper<Object, Text, Text, IntWritable>{
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        @Override
        public void map(Object o, Text text, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {
            StringTokenizer itr = new StringTokenizer(text.toString());
            while (itr.hasMoreElements()){
                word.set(itr.nextToken());
                outputCollector.collect(word, one);
            }
        }
    }


    /**
     * count Reduce
     * @author Xender
     * @Date 17/1/4 上午10:25
     * The word 'impossible' is not in my dictionary.
     */
    public static class WordCountReducer extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
        private IntWritable result = new IntWritable();

        @Override
        public void reduce(Text text, Iterator<IntWritable> iterator, OutputCollector<Text, IntWritable> outputCollector, Reporter reporter) throws IOException {
            int sum = 0;
            while (iterator.hasNext()){
                sum += iterator.next().get();
            }
            result.set(sum);
            outputCollector.collect(text, result);
        }
    }


    /**
     * count inlet
     * @author Xender
     * @Date 17/1/4 上午10:47
     * The word 'impossible' is not in my dictionary.
     */
    public static void main(String[] args) throws Exception {
        String input = "hdfs://192.168.1.210:9000/user/hdfs/o_t_account";
        String output = "hdfs://192.168.1.210:9000/user/hdfs/o_t_account/result";

        JobConf conf = new JobConf(WordCount.class);
        conf.setJobName("WordCount");
        conf.addResource("classpath:/hadoop/core-site.xml");
        conf.addResource("classpath:/hadoop/hdfs-site.xml");
        conf.addResource("classpath:/hadoop/mapred-site.xml");

        conf.setOutputKeyClass(Text.class);
        conf.setOutputValueClass(IntWritable.class);

        conf.setMapperClass(WordCountMapper.class);
        conf.setCombinerClass(WordCountReducer.class);
        conf.setReducerClass(WordCountReducer.class);

        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);

        FileInputFormat.setInputPaths(conf, new Path(input));
        FileOutputFormat.setOutputPath(conf, new Path(output));
        // 运行Job并分解输入数据集
        JobClient.runJob(conf);
        System.exit(0);
    }
}
