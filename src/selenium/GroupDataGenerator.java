package selenium;

import utils.ListOf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupDataGenerator {
    public static void main(String[] args) {
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
            System.out.println("Unknow format: " + format);
            return;
        }
    }

    private static void saveGroupsToXMLFile(List<GroupData> groupDataList, File file) {

    }

    private static void saveGroupsToCSVFile(List<GroupData> groupDataList, File file) {

    }

    public static List<GroupData> generateRandomGroups(int amount) {
        List<GroupData> list = new ArrayList<GroupData>();
        for (int i = 0; i < amount ; i++) {
            GroupData group = new GroupData()
                    .withName(generateRandomString("name"))
                    .withHeader(generateRandomString("footer"))
                    .withFooter(generateRandomString("header"));
            list.add(group);
        }
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
