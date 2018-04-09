package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constants.DBType;
import model.OptionModel;
import model.QuestionModel;
import model.Record;
import utils.DBUtil;
import utils.Result;

public class One2ManyDataTest2 {
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		
		StringBuilder sql = new StringBuilder(400);
		sql.append("SELECT A.no,A.content,B.question_no,B.option_no,B.option_name,B.option_score,B.option_content ");
		sql.append("FROM (SELECT NO,content FROM t_ass_question) A ");
		sql.append("LEFT JOIN ");
		sql.append("(SELECT question_no,option_no,option_name,option_score,option_content FROM t_ass_option) B ");
		sql.append("ON A.no=B.question_no ");
		sql.append("ORDER BY no,option_no");
		
		List<Record> list = new ArrayList<>();
		
		Connection connection = DBUtil.getConnection(DBType.MYSQL);
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql.toString());
		
		while(rs.next()) {
			Record record = new Record();
			
			record.setNo(rs.getInt(1));
			record.setContent(rs.getString(2));
			record.setQuestionNo(rs.getInt(3));
			record.setOptionNo(rs.getInt(4));
			record.setOptionName(rs.getString(5));
			record.setOptionScore(rs.getInt(6));
			record.setOptionContent(rs.getString(7));
			
			list.add(record);
		}
		
		Map<String, List<OptionModel>> map = new HashMap<>();
		
        for (Record record : list) {
    		OptionModel option = new OptionModel();
    		option.setQuestionNo(record.getOptionNo());
    		option.setOptionNo(record.getOptionNo());
    		option.setOptionName(record.getOptionName());
    		option.setOptionScore(record.getOptionScore());
    		option.setOptionContent(record.getOptionContent());
    		
        	if (map.containsKey(record.getNo() + "#" + record.getContent())) {
        		map.get(record.getNo() + "#" + record.getContent()).add(option);
        	} else {
        		List<OptionModel> optionList = new ArrayList<>();
        		optionList.add(option);
        		
        		map.put(record.getNo() + "#" + record.getContent(), optionList);
        	}
        }
        
        List<QuestionModel> retList = new ArrayList<>(list.size());
        
        
        for (Map.Entry<String, List<OptionModel>> entry: map.entrySet()) {
        	String key = entry.getKey();
        	QuestionModel question = new QuestionModel();
        	question.setNo(Integer.parseInt(key.split("#")[0]));
        	question.setContent(key.split("#")[1]);
        	question.setList(entry.getValue());
        	
        	retList.add(question);
        }
        
        Collections.sort(retList,new Comparator<QuestionModel>(){
            @Override
            public int compare(QuestionModel o1, QuestionModel o2) {
                 return o1.getNo() - o2.getNo();
            }
         });
        
//      retList.sort(new Comparator<QuestionModel>() {
//            @Override
//            public int compare(QuestionModel o1, QuestionModel o2) {
//                 return o1.getNo() - o2.getNo();
//            }
//		});
		
		Result result = new Result();
		result.setResult(1, "ok", retList);
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		System.out.println(result.toString());
	}
}
