package mohammedzaheeruddin.recyclerpagination.db;

import java.util.ArrayList;

/**
 * Created by mohammedzaheeruddin on 25-Mar-18.
 */
public class DaoUtils {

    /*
     * Sqlite Data base and table declaration
     */

    public static final String DATABASE_NAME = "zebpay.db.ver.0.1";
    public static final int DATABASE_VERSION = 1;

    // Tasks Table
    public static final String DATABASE_USER_DETAILS_TABLE_NAME = "zeb_pay_user_details_table";

    /*
    * Task table field declaration
    */
    public static final String USER_ID = "USER_ID";
    public static final String USER_NAME = "USER_NAME";
    public static final String REPUTATION = "REPUTATION";
    public static final String PROFILE_IMAGE_URL = "PROFILE_IMAGE_URL";

    protected static ArrayList<String> mUserDetailsTable = null;

    public static void initUserDetailsList() {
        mUserDetailsTable = new ArrayList<String>();
        mUserDetailsTable.add(USER_ID);
        mUserDetailsTable.add(USER_NAME);
        mUserDetailsTable.add(REPUTATION);
        mUserDetailsTable.add(PROFILE_IMAGE_URL);
    }

    //  method for initialization of filled in personal task table. .
    public static ArrayList<String> getUserTableColumns() {
        if ((mUserDetailsTable == null) || (mUserDetailsTable.size() == 0)) {
            initUserDetailsList();
        }
        return mUserDetailsTable;
    }

}
