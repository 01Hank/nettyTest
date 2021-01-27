import com.nettyTest.Util.ReadExcelTools;
import org.apache.poi.openxml4j.opc.internal.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 老板让做的验算方法
 */
public class formatExcel {
    public static void main(String[] args) {
        String filePath = "D:\\work\\智能体升级速查表3-1-27.xlsx";
        String outFilePath = "D:\\work\\验算结果.txt";
        try {
            List<String[]> strings = ReadExcelTools.readExcel(filePath, 7);

            List<Integer> valueList = new ArrayList<>();

            //开始验算
            for (int i = 2, len = strings.size(); i < len; i++) {
                String[] strArr = strings.get(i);
                //段位
                int dw = Integer.parseInt(strArr[0]);
                //等级
                int lv = Integer.parseInt(strArr[1]);
                //研发能力
                int RD = Integer.parseInt(strArr[2]);
                //抗疲劳
                int rf = Integer.parseInt(strArr[3]);
                //研发速度
                int speed = Integer.parseInt(strArr[4]);
                //HP
                int hp = Integer.parseInt(strArr[5]);

                //验算
                int value = checkCul(dw, lv, RD, rf, speed, hp);
                valueList.add(value);
            }

            //写入结果
            writeFile(valueList, outFilePath);

            System.out.println("验算完成!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * 写入文件
     *
     * @param valueList   写入数据
     * @param outFilePath 写入文件目录
     */
    private static void writeFile(List<Integer> valueList, String outFilePath) {
        try {
            File file = new File(outFilePath);
            FileWriter fileWriter = new FileWriter(file);

            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i = 0, len = valueList.size(); i < len; i++) {
                printWriter.println(new String(valueList.get(i).toString().getBytes(), "utf-8"));
            }


            fileWriter.flush();
            printWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 验算结果
     *
     * @param dw    段位
     * @param lv    等级
     * @param RD    研发能力
     * @param rf    抗疲劳
     * @param speed 研发速度
     * @param hp    HP
     * @return
     */
    private static int checkCul(int dw, int lv, int RD, int rf, int speed, int hp) {
        int cul = 0;

        //研发能力*研发速度*保留系数1
        cul = RD * speed * 1;
        return cul;
    }


}
