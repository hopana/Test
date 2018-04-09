package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import constants.DBType;
import model.OptionModel;
import model.QuestionModel;
import model.Record;
import utils.DBUtil;
import utils.Result;

public class One2ManyDataTest {
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
		
		List<QuestionModel> retList = new ArrayList<>(list.size());
		
        for (int i = 0; i < list.size(); ) {
            QuestionModel question = new QuestionModel();
            question.setNo(list.get(i).getNo());
            question.setContent(list.get(i).getContent());

            List<OptionModel> optionList = new ArrayList<>();
            
            OptionModel optionDTO = new OptionModel();
            optionDTO.setQuestionNo(question.getNo());
            optionDTO.setOptionNo(list.get(i).getOptionNo());
            optionDTO.setOptionName(list.get(i).getOptionName());
            optionDTO.setOptionScore(list.get(i).getOptionScore());
            optionDTO.setOptionContent(list.get(i).getOptionContent());
            
            optionList.add(optionDTO);
            
            
            while (i++ < list.size() -1 && list.get(i).getNo().intValue() == question.getNo().intValue()) {
                OptionModel optionDTO1 = new OptionModel();
                optionDTO1.setQuestionNo(question.getNo());
                optionDTO1.setOptionNo(list.get(i).getOptionNo());
                optionDTO1.setOptionName(list.get(i).getOptionName());
                optionDTO1.setOptionScore(list.get(i).getOptionScore());
                optionDTO1.setOptionContent(list.get(i).getOptionContent());

                optionList.add(optionDTO1);
            }

            question.setList(optionList);
            retList.add(question);
        }
		
		Result result = new Result();
		result.setResult(1, "ok", retList);
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		System.out.println(result.toString());
	}
}
