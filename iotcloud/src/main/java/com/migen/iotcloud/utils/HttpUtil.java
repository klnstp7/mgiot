package com.migen.iotcloud.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class HttpUtil
{
	public static String sendPostJson(JSONObject obj, String sendUrl)
	{
		String rt = "";
		try
		{
			// 创建连接
			URL url = new URL(sendUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/json");
			connection.connect();
			// POST请求
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			// String json = URLEncoder.encode(obj.toString(), "utf-8");
			System.out.println(DateUtils.getDateTime(new Date()) + ", HttpUtil send json==>" + obj.toString());
			bw.write(obj.toString());
			bw.flush();
			bw.close();
			// 读取响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String lines;
			StringBuffer sb = new StringBuffer("");
			while ((lines = reader.readLine()) != null)
			{
				// lines = URLDecoder.decode(lines, "utf-8");
				sb.append(lines);
			}
			System.out.println(DateUtils.getDateTime(new Date()) + ", HttpUtil rt==>" + sb.toString());
			reader.close();
			// 断开连接
			connection.disconnect();
			rt = sb.toString();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return rt;
	}

	public static String sendGet(String url)
	{
		String result = "";
		BufferedReader in = null;
		try
		{
			String urlNameString = url;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			// connection.setRequestProperty("user-agent",
			// "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet())
			{
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null)
			{
				result += line;
			}
		}
		catch (Exception e)
		{
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally
		{
			try
			{
				if (in != null)
				{
					in.close();
				}
			}
			catch (Exception e2)
			{
				e2.printStackTrace();
			}
		}
		return result;
	}
}
