package database.test;

import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.AbstractDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.ext.h2.H2DataTypeFactory;
import org.dbunit.util.Base64;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class DbUnitTester extends AbstractDatabaseTester implements TestRule  {

	private final String CONNECTIONURL;
	private final String USERNAME;
	private final String PASSWORD;

	public DbUnitTester(String driverClass ,String connectionUrl) {
		this(driverClass,connectionUrl,null,null);
	}

	public DbUnitTester(String driverClass ,String connectionUrl,String username ,String password) {
		this(driverClass, connectionUrl,username,password,null);
	}

	public DbUnitTester(String driverClass ,String connectionUrl,String username ,String password,String schema) {
		super(schema);
		this.CONNECTIONURL = connectionUrl;
		this.USERNAME = username;
		this.PASSWORD = password;
		assertNotNullNorEmpty("driverClass", driverClass);

		try{
			Class.forName(driverClass);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public IDatabaseConnection getConnection() throws Exception {
		Connection conn = null;
		if(USERNAME == null && PASSWORD == null){
			conn = DriverManager.getConnection(CONNECTIONURL);
		}else {
			conn = DriverManager.getConnection(CONNECTIONURL, USERNAME, PASSWORD);
		}
		DatabaseConnection dbConnection = new DatabaseConnection(conn,getSchema());
		DatabaseConfig config = dbConnection.getConfig();
		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
		return dbConnection;
	}

	protected void executeQuery(String sql)throws Exception {
		Connection conn = getConnection().getConnection();
		conn.createStatement().execute(sql);
		conn.commit();
		conn.close();
	}

	protected void before() throws Exception {}
	protected void after() throws Exception {}

	abstract protected IDataSet createdaDataSet() throws Exception;

	@Override
	public Statement apply(Statement arg0, Description arg1) {
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				before();
				setDataSet(createdaDataSet());
				onSetup();
				try {
					base.evaluate();
				}finally{
					try{
						after();
						}finally{
						onTearDown();
				}
				}
			}
		};
	}




}
