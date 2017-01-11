package enums;

/**
 * SimpleEnumDemo
 *
 * Java中Enum的简单用法
 * @author xiaoyy
 * @Date 2017-01-11 上午10:01
 * The word 'impossible' is not in my dictionary.
 */
public enum SimpleEnumDemo {
    YANGYANG("The given name of me"),
    XIAO("The family name of me");
    private String context;
    private String getContext(){
        return this.context;
    }
    private SimpleEnumDemo(String context){
        this.context = context;
    }

    public static void main(String[] args) {
        for (SimpleEnumDemo name: SimpleEnumDemo.values()){
            System.out.println(name+":"+name.getContext());
        }
    }

}
