package hadoop;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

import java.io.IOException;
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

}
