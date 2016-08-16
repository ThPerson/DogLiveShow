package com.example.mypc.dogliveshow.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by JiaFan on 2016/8/16 08:57
 * QQ：1319662955
 */
public class UserDao {
    private ORMliteHelper orMliteHelper;
    private static Dao<User,Integer> dao;
    private static UserDao uDao;

    private UserDao(Context context){
        this.orMliteHelper = new ORMliteHelper(context);
        try {
            dao = orMliteHelper.getDao(User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static UserDao userDaoInstence(Context context){
        if(uDao==null){
            uDao = new UserDao(context);
        }
        return uDao;
    }
    //增加
    public static void add(User user,Context context){
        userDaoInstence(context);
        try {
            dao.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //删除
    public static void del(Context context,String title){
        userDaoInstence(context);
        DeleteBuilder builder = dao.deleteBuilder();
        try {
            builder.where().eq("favContent", title);
            builder.delete();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //修改
    public static void update(Context context,User user){
        userDaoInstence(context);
        UpdateBuilder builder = dao.updateBuilder();
        try {
            builder.where().eq("name",user.getName());
            builder.updateColumnValue("pwd","xxx");
            builder.update();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询
    public static List<User> quaryAll(Context context){
        List<User> listUsers = new ArrayList<>();
        userDaoInstence(context);
        try {
            listUsers = dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers;
    }
    //有条件查询
    public static int quaryOne(Context context,String url){
        List<User> listUsers = new ArrayList<>();
        userDaoInstence(context);
        try {
            QueryBuilder builder = dao.queryBuilder();
            builder.where().eq("favUrl",url);
            listUsers = builder.query();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listUsers.size();
    }
}
