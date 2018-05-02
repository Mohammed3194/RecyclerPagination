package mohammedzaheeruddin.recyclerpagination.entity;

import java.util.ArrayList;

/**
 * Created by mohammedzaheeruddin on 25-Mar-18.
 */
public class ApiData {

    ArrayList<Item> items = new ArrayList<>();
    boolean has_more;
    Integer quota_max;
    Integer quota_remaining;

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public Integer getQuota_max() {
        return quota_max;
    }

    public void setQuota_max(Integer quota_max) {
        this.quota_max = quota_max;
    }

    public Integer getQuota_remaining() {
        return quota_remaining;
    }

    public void setQuota_remaining(Integer quota_remaining) {
        this.quota_remaining = quota_remaining;
    }
}
