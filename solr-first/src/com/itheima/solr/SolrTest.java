package com.itheima.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrTest {
	@Test
	public void addDocument() throws Exception{
		//创建SolrServer对象
		SolrServer solrServer=new HttpSolrServer("http://localhost:8080/solr/collection2");
		//创建SolrInputDocument对象
		SolrInputDocument document = new SolrInputDocument();
		//添加域
		document.addField("id", "1");
		document.addField("title", "aaaaaaaaaaaaa");
		//把文档加入索引库
		solrServer.add(document);
		//提交
		solrServer.commit();
	}
	@Test 
	public void deleteDocument()throws Exception{
		SolrServer solrServer= new HttpSolrServer("http://localhost:8080/solr/collection2");
		//根据id删除
		//solrServer.deleteById("1");
		//根据查询对象删除
		solrServer.deleteByQuery("*:*");
		solrServer.commit();
	}
}
