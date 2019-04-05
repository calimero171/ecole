package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class AccessBdd {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private String user = "javauser";
	private String mdp = "test";
	final String url = "jdbc:mysql://localhost:3306/ecole?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public List<User> getAllUser() throws Exception {
		List<User> userList = new ArrayList<>();
		try {
			// Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// parametrage de la connection
			this.connect = DriverManager.getConnection(this.url, this.user, this.mdp);
			// statement autorise sql query
			this.statement = this.connect.createStatement();
			// ResultSet obtenir le résultat de la query
			this.resultSet = this.statement.executeQuery("select * from ecole.user");
			while (this.resultSet.next()) {
				Long id = this.resultSet.getLong("id");
				String nom = this.resultSet.getString("nom");
				String prenom = this.resultSet.getString("prenom");
				// User user = new User(id, "email",nom, prenom);
				User user = new User(id, "email", nom, prenom);
				userList.add(user);
				System.out.println("test" + user);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (this.connect != null) {
				try {
					this.connect.close();
				} catch (SQLException e) {
					System.out.println(e);
				}

			}
			if (this.statement != null) {
				try {
					this.statement.close();
				} catch (SQLException e) {
					System.out.println(e);
				}

			}
			if (this.resultSet != null) {
				try {
					this.resultSet.close();
				} catch (SQLException e) {
					System.out.println(e);
				}

			}
		}
		return userList;
	}

	public void inscrireUser(String nom, String prenom) {
		try {
			this.connect = DriverManager.getConnection(this.url, this.user, this.mdp);

			preparedStatement = connect.prepareStatement("insert into  ecole.user values ( default, ?, ?)");
		
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, prenom);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (this.connect != null) {
                try {
                    this.connect.close();
                } catch (SQLException e){
                    System.out.println(e);
                }

            }
            if (this.statement != null) {
                try {
                    this.statement.close();
                } catch (SQLException e){
                    System.out.println(e);
                }

            }
            if (this.resultSet != null) {
                try {
                    this.resultSet.close();
                } catch (SQLException e){
                    System.out.println(e);
                }

            }
        }
	}

//         preparedStatement = connect
//                 .prepareStatement("insert into  feedback.comments values (default, ?, ?, ?, ? , ?, ?)");
//         preparedStatement.setString(1, "Test");
//         preparedStatement.setString(2, "TestEmail");
//         preparedStatement.setString(3, "TestWebpage");
//         preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
//         preparedStatement.setString(5, "TestSummary");
//         preparedStatement.setString(6, "TestComment");
//         preparedStatement.executeUpdate

}