package selenium;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import utils.ListOf;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupDataGenerator {
    public static void main(String[] args) throws IOException {
        if (args.length < 3) {
            System.out.println("Count of params less than 3");
            return;
        }

        int amount = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        String format = args[2];

        List<GroupData> groupDataList = generateRandomGroups(amount);

        if("csv".equals(format)) {
            saveGroupsToCSVFile(groupDataList, file);
        } else if("xml".equals(format)){
            saveGroupsToXMLFile(groupDataList, file);
        } else {
            System.out.println("Unknown format: " + format);
            return;
        }
    }

    private static void saveGroupsToXMLFile(List<GroupData> groupDataList, File file) throws IOException {
        XStream xstream = new XStream(new DomDriver());
        xstream.alias("group", GroupData.class);
        String xml = xstream.toXML(groupDataList);
        FileWriter writer = new FileWriter(file);
        writer.write(xml);
        writer.close();
    }
    public static List<GroupData> loadGroupsFromXMLFile(File file) {

        XStream xstream = new XStream(new DomDriver());
        xstream.alias("group", GroupData.class);
        return (List<GroupData>) xstream.fromXML(file);
    }


    private static void saveGroupsToCSVFile(List<GroupData> groupDataList, File file) throws IOException {
        FileWriter writer = new FileWriter(file);
        for (GroupData group: groupDataList) {
            writer.write(group.getName() + "," + group.getHeader() + "," + group.getFooter() +",!" +"\n");
        }
        writer.close();
    }

    public static List<GroupData> generateRandomGroups(int amount) {
        List<GroupData> list = new ArrayList<GroupData>();
        for (int i = 0; i < amount ; i++) {
            GroupData group = new GroupData()
                    .withName(generateRandomString("name"))
                    .withHeader(generateRandomString("header"))
                    .withFooter(generateRandomString("footer"));
            list.add(group);
        }
        return list;
    }

    public static List<GroupData> loadGroupsFromCsvFile(File file) throws IOException {
        List<GroupData> list = new ArrayList<GroupData>();
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader =  new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] parts = line.split(",");
            GroupData group = new GroupData()
                    .withName(parts[0])
                    .withHeader(parts[1])
                    .withFooter(parts[2]);
            list.add(group);
            line = bufferedReader.readLine();
        }

        reader.close();
        return list;
    }

    private static String generateRandomString(String title) {
        Random rnd = new Random();
        if (rnd.nextInt(10) == 0) {
            return "";
        } else {
            return title + rnd.nextInt();
        }
    }
}
