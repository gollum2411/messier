package com.example.messieriteso.database;

import java.util.ArrayList;

import com.example.messieriteso.beans.Object;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;






public class ObjectControl {
	
	/**
	
	 */
	public ArrayList<Object> getObjectsWhere(String strWhere, String strOrderBy,
			DataBaseHandler dh) {
		ArrayList<Object> list = new ArrayList<Object>();
		// SELECT
		String selectQuery = "SELECT  " + DataBaseHandler.OBJECT_MESSIER + ","
				+ DataBaseHandler.OBJECT_NGC + ","
				+ DataBaseHandler.OBJECT_COMMON + ","
				+ DataBaseHandler.OBJECT_PICTURE_ID + ","
				+ DataBaseHandler.OBJECT_TYPE + ","
				+ DataBaseHandler.OBJECT_DISTANCE + ","
				+ DataBaseHandler.OBJECT_CONSTELLATION + ","
				+ DataBaseHandler.OBJECT_APPARENTM + "  FROM "
				+ DataBaseHandler.OBJECT;

		// WHERE
		if (strWhere != null) {
			selectQuery += " WHERE " + strWhere;
		}

		// ORDER BY
		if (strOrderBy != null) {
			selectQuery += " ORDER BY " + strOrderBy;
		}
		SQLiteDatabase db = dh.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		// Looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Object object = new Object();
				object.setMessier(cursor.getString(0));
				object.setNgc(cursor.getString(1));
				object.setCommon(cursor.getString(2));
				object.setPicture_id(Integer.parseInt(cursor.getString(3)));
				object.setType(cursor.getString(4));
				object.setDistance(Float.parseFloat(cursor.getString(5)));
				object.setConstellation(cursor.getString(6));
				object.setApparentm(Float.parseFloat(cursor.getString(7)));
				// Adding User to list
				list.add(object);
			} while (cursor.moveToNext());
		}
		try {
			cursor.close();
			db.close();
		} catch (Exception e) {
		}
		db = null;
		cursor = null;
		// return User list
		return list;
	}

}
