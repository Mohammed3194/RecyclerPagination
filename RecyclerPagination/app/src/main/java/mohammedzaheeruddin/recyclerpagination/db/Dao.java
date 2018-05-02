package mohammedzaheeruddin.recyclerpagination.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;

import mohammedzaheeruddin.recyclerpagination.entity.DisplayItem;

/**
 * Created by mohammedzaheeruddin on 25-Mar-18.
 */
public class Dao {

    protected Context mContext;
    protected static SQLiteDatabase mSqlDatabase;
    protected SQLiteStatement mInsertStatement;
    static OpenHelper lOpenHelper;

    public Dao(Context context) {
        mContext = context;
        closeDatabase();
        lOpenHelper = new OpenHelper(mContext);
        mSqlDatabase = lOpenHelper.getWritableDatabase();
    }

    // insert statement to insert fields in personal task table . .
    public String getInsertSqlUserDetails() {
        ArrayList<String> lColumns = DaoUtils.getUserTableColumns();
        StringBuffer lBuffer = new StringBuffer();
        lBuffer.append("insert into  ");
        lBuffer.append(DaoUtils.DATABASE_USER_DETAILS_TABLE_NAME);
        lBuffer.append("(");
        for (int i = 0; i < lColumns.size(); i++) {
            lBuffer.append(lColumns.get(i));
            if (i < (lColumns.size() - 1)) {
                lBuffer.append(",");
            }
        }
        lBuffer.append(")");
        lBuffer.append(" values (");
        for (int i = 0; i < lColumns.size(); i++) {
            lBuffer.append("?");
            if (i < lColumns.size() - 1) {
                lBuffer.append(",");
            }

        }
        lBuffer.append(");");

        return lBuffer.toString();

    }

    public void insertUserDetailsData(String userId,
                                       String userName,
                                       String reputation,
                                       String profileImage){
        if (!userIdExist(userId)) {
            mSqlDatabase = lOpenHelper.getWritableDatabase();
            mInsertStatement = mSqlDatabase.compileStatement(getInsertSqlUserDetails());
            mInsertStatement.bindString(1,
                    userId);
            mInsertStatement.bindString(2,
                    userName);
            mInsertStatement.bindString(3,
                    reputation);
            mInsertStatement.bindString(4,
                    profileImage);
            mInsertStatement.executeInsert();
        }else {
            mSqlDatabase = lOpenHelper.getWritableDatabase();
            ArrayList<String> lColumns = DaoUtils.getUserTableColumns();
            ContentValues conValue = new ContentValues();
            conValue.put(lColumns.get(0),
                    userId);
            conValue.put(lColumns.get(1),
                    userName);
            conValue.put(lColumns.get(2),
                    reputation);
            conValue.put(lColumns.get(3),
                    profileImage);
            mSqlDatabase.update(DaoUtils.DATABASE_USER_DETAILS_TABLE_NAME,
                    conValue,
                    DaoUtils.USER_ID + "=?",
                    new String[]{userId});
        }
        mSqlDatabase.close();
    }

    public List<DisplayItem> getUserDetailsInDescendingOrder(){
        List<DisplayItem> allRecords = new ArrayList<DisplayItem>();

        String selectQuery = "SELECT * FROM zeb_pay_user_details_table " ;
        mSqlDatabase = lOpenHelper.getReadableDatabase();
        Cursor lCursor = mSqlDatabase.rawQuery( selectQuery,
                null );

        DisplayItem displayItem = null;
        if( lCursor.moveToFirst()){
            do {
                displayItem = new DisplayItem();
                displayItem.setUserId(lCursor.getString(1));
                displayItem.setUserName(lCursor.getString(2));
                displayItem.setReputation(Integer.parseInt(lCursor.getString(3)));
                displayItem.setProfileImageUrl(lCursor.getString(4));

                allRecords.add(displayItem);
            }
            while( lCursor.moveToNext() );
        }
        lCursor.close();
        return allRecords;
    }

    // Method to check record is exist or not if exist then returning true
    public boolean userIdExist(String user_id) {
        mSqlDatabase = lOpenHelper.getReadableDatabase();
        Cursor mCursor = mSqlDatabase.rawQuery("SELECT * FROM "
                        + DaoUtils.DATABASE_USER_DETAILS_TABLE_NAME
                        + " WHERE "
                        + DaoUtils.USER_ID
                        + "=?",
                new String[]{user_id});
        if (mCursor.moveToFirst()) {
            mSqlDatabase.close();
            return true;
        } else {
            mSqlDatabase.close();
            return false;
        }
    }

    // Method to close database if it is open
    public void closeDatabase() {
        if (mSqlDatabase != null && mSqlDatabase.isOpen()) {
            mSqlDatabase.close();
        }
    }
}
