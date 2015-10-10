import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * Creation Date:2015年3月24日-上午9:55:43
 * 
 * Copyright 2008-2015 ? 同程网 Inc. All Rights Reserved
 */

/**
 * Description Of The Class<br/>
 * QQ:414679395
 *
 * @author 	(刘树东 10546)
 * @version 1.0.0, 2015年3月24日-上午9:55:43
 * @since 2015年3月24日-上午9:55:43
 */
public class IKAnalyzerDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//String str = "李天一，现名李冠丰。著名歌唱家李双江和知名歌唱家梦鸽之子。根据司法机关公布资料显示，李天一出生于1996年4月。曾就读北京海淀区中关村第三小学、人民大学附中、美国Shattuck-St. Mary's School（沙特克圣玛丽学院）冰球学校。2011年9月6日，因与人斗殴被拘留教养1年。2012年9月19日，李天一被解除教养。2013年2月22日，因涉嫌轮奸案被刑事拘留，后因可查资料显示未成年，移交少管所。3月7日，中央电视台新闻中心官方微博发布了一条消息，称李天一因涉嫌强奸罪，已被检察机关批捕。2013年9月，李双江一篇旧文证实李天一成年。";
	//	String str="天目湖南山竹海";
		String str="上海南站";
		System.out.println(str);
		
		System.out.println("Begin to analyze from IKAnalyer");
		Analyzer analyzer = new IKAnalyzer(true);
		StringReader reader = new StringReader(str);
		TokenStream stream = analyzer.tokenStream("", reader);
		OffsetAttribute offset = stream.addAttribute(OffsetAttribute.class);
		CharTermAttribute term = stream.addAttribute(CharTermAttribute.class); 
		TypeAttribute type = stream.addAttribute(TypeAttribute.class);
		//CharTermAttribute term = stream.getAttribute(CharTermAttribute.class); 
		while(stream.incrementToken()){
			System.out.println(offset.startOffset() + "-" + offset.endOffset() + ":" + term.toString() + "|" + type.type());
		}
		analyzer.close();
		reader.close();
		System.out.println("Finish it by IKAnalyzer");
		
	
		//show();
//		System.out.println("Get the results from IKSegmenter");
//		StringReader reader2 =  new StringReader(str);
//		IKSegmenter seg = new IKSegmenter(reader2,true);
//		Lexeme lex = null;
//		while((lex = seg.next()) != null){
//			System.out.print(lex.getLexemeText() + "|");
//		}
//		System.out.println("Finish it by IKSegmenter");
		
		return ;
	}
  
	 public static void show() throws Exception{
		 TokenStream ts = null;
		 Analyzer analyzer = new IKAnalyzer(true);  
	     ts= analyzer.tokenStream("myfield", new StringReader("剑生杨朝来访问控制列表这是一个中文分词的例子，你可以直接运行它！IKAnalyer can analysis english text too"));

         //获取词元位置属性
         OffsetAttribute  offset = ts.addAttribute(OffsetAttribute.class);

         //获取词元文本属性
         CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);

         //获取词元文本属性
         TypeAttribute type = ts.addAttribute(TypeAttribute.class); 

         //重置TokenStream（重置StringReader）
         ts.reset();

         //迭代获取分词结果
         while (ts.incrementToken()) {
        	 System.out.println(offset.startOffset()+" - "+ offset.endOffset() +" : " + term.toString() + " | " + type.type());

         }
	 }
	 
}

