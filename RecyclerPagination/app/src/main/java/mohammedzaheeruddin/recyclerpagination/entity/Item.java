package mohammedzaheeruddin.recyclerpagination.entity;

/**
 * Created by mohammedzaheeruddin on 25-Mar-18.
 */
public class Item {

    private BadgeCount badge_counts;
    private Integer account_id;
    private Boolean is_employee;
    private Long last_modified_date;
    private Long last_access_date;
    private Integer age;
    private Integer reputation_change_year;
    private Integer reputation_change_quarter;
    private Integer reputation_change_month;
    private Integer reputation_change_week;
    private Integer reputation_change_day;
    private Integer reputation;
    private Long creation_date;
    private String user_type;
    private Integer user_id;
    private Integer accept_rate;
    private String location;
    private String website_url;
    private String link;
    private String profile_image;
    private String display_name;

    public Long getLast_access_date() {
        return last_access_date;
    }

    public void setLast_access_date(Long last_access_date) {
        this.last_access_date = last_access_date;
    }

    public Long getLast_modified_date() {
        return last_modified_date;
    }

    public void setLast_modified_date(Long last_modified_date) {
        this.last_modified_date = last_modified_date;
    }

    public Long getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Long creation_date) {
        this.creation_date = creation_date;
    }

    public BadgeCount getBadge_counts() {
        return badge_counts;
    }

    public void setBadge_counts(BadgeCount badge_counts) {
        this.badge_counts = badge_counts;
    }

    public Integer getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }

    public Boolean getIs_employee() {
        return is_employee;
    }

    public void setIs_employee(Boolean is_employee) {
        this.is_employee = is_employee;
    }



    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getReputation_change_year() {
        return reputation_change_year;
    }

    public void setReputation_change_year(Integer reputation_change_year) {
        this.reputation_change_year = reputation_change_year;
    }

    public Integer getReputation_change_quarter() {
        return reputation_change_quarter;
    }

    public void setReputation_change_quarter(Integer reputation_change_quarter) {
        this.reputation_change_quarter = reputation_change_quarter;
    }

    public Integer getReputation_change_month() {
        return reputation_change_month;
    }

    public void setReputation_change_month(Integer reputation_change_month) {
        this.reputation_change_month = reputation_change_month;
    }

    public Integer getReputation_change_week() {
        return reputation_change_week;
    }

    public void setReputation_change_week(Integer reputation_change_week) {
        this.reputation_change_week = reputation_change_week;
    }

    public Integer getReputation_change_day() {
        return reputation_change_day;
    }

    public void setReputation_change_day(Integer reputation_change_day) {
        this.reputation_change_day = reputation_change_day;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }



    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getAccept_rate() {
        return accept_rate;
    }

    public void setAccept_rate(Integer accept_rate) {
        this.accept_rate = accept_rate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }
}
