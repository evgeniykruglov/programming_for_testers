package selenium;

public class GroupData implements Comparable<GroupData>{
    private String name;
    private String header;
    private String footer;

    public GroupData(String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public GroupData() {

    }


    public void setName(String name) {
        this.name = name;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        return getName().equals(groupData.getName());
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public int compareTo(GroupData o) {
        return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    }
    /*
        @Override
        public String toString() {
        return "GroupData [name" + name + "]";
    }
     */
}
