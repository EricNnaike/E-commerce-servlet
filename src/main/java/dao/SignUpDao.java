package dao;

import model.User;
import util.DatabaseConnection;

import javax.servlet.http.HttpSession;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpDao {

    public boolean signUp(User user) throws SQLException {
        boolean result = false;
       String signupQuery = "INSERT INTO tblcustomer(name, email, password, mobile, gender, address, pincode) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement st = DatabaseConnection.getConnection().prepareStatement(signupQuery);
        st.setString(1, user.getName());
        st.setString(2, user.getEmail());
        st.setString(3, user.getPassword());
        st.setString(4, user.getMobile());
        st.setString(5, user.getGender());
        st.setString(6, user.getAddress());
        st.setString(7, user.getPincode());

        int status = st.executeUpdate();
        if(status > 0){
            result = true;
        }

        return result;
    }
}


