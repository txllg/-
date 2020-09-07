import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) throws IOException {
        //读取文件
        BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\大三上\\软工导论\\第二周\\yq_in.txt"),"gbk"));
        List<String> list=new ArrayList();

        String line=null;
        while((line=reader.readLine())!=null){
            list.add(line);
        }


        reader.close();

        //写入文件

        File outfile=new File("D:\\大三上\\软工导论\\第二周\\result.txt");
        FileOutputStream fos=new FileOutputStream(outfile);
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(fos));

        String province2=null;
        for(int i=0;i<list.size();i++){
            String word=list.get(i);

            String province1=word.substring(0,3);
            if(!province1.equals(province2)){
                if(province2!=null){

                    bw.newLine();
                    System.out.println("");
                }
                bw.write(province1);
                bw.newLine();
                System.out.println(province1);

            }
            if(!word.contains("待明确地区")){
                String str=word.substring(4,word.length());
                bw.write(str);
                System.out.println(str);
            }
            bw.newLine();
            province2=province1;

        }

        bw.close();

//        控制台输出


    }
}
