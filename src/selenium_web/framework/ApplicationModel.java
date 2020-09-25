package selenium_web.framework;

import selenium_web.tests.GroupData;
import utils.ListOf;
import utils.SortedListOf;

import java.util.List;

public class ApplicationModel {
    private SortedListOf<GroupData> groups;

    public SortedListOf<GroupData> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupData> groups) {
        this.groups = new SortedListOf(groups);
    }

    public ApplicationModel addGroup(GroupData groupData) {
        groups.add(groupData);
        return this;
    }

    public ApplicationModel removeGroup(int index) {
        groups.remove(index);
        return this;
    }


}
