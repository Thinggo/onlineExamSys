import java.sql.SQLException;
import java.util.*;

import com.csmy.db.*;
import com.csmy.object.*;
import com.csmy.dao.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        QuestionDao dao=new QuestionDao();
        
        try {
        	PagerModel<Question> p=dao.list(0, "id", 100, 1, "courseId=1");
            List<Question> list=p.getRows();
			for(int i=0;i<list.size();i++){
				Question q=list.get(i);
				System.out.println(q.getTitle());
				if(q.getList()!=null)
				 System.out.println(q.getList().get(1).getName());
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
