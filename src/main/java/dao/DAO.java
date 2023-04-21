package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	protected static Connection conn = null;
	protected static PreparedStatement ps = null;
	protected static ResultSet rs = null;
}
