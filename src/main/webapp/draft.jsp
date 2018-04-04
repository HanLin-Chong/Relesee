<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page import="net.sf.json.JSONObject,net.sf.json.JSONArray,net.sf.json.JsonConfig" %>
<%
	
	System.out.println("draft");
	
	/*
	 Map<String, Object> json = new HashMap<String, Object>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        
        页面控件的文件流
        MultipartFile multipartFile = null;
        Map map =multipartRequest.getFileMap();
         for (Iterator i = map.keySet().iterator(); i.hasNext();) {
                Object obj = i.next();
                multipartFile=(MultipartFile) map.get(obj);

               }
         获取文件的后缀
        String filename = multipartFile.getOriginalFilename();

        InputStream inputStream;
        String path = "";
        String newVersionName = "";
        String fileMd5 = "";
        try {

            inputStream = multipartFile.getInputStream();
            File tmpFile = File.createTempFile(filename,
                    filename.substring(filename.lastIndexOf(".")));
            fileMd5 = Files.hash(tmpFile, Hashing.md5()).toString();
            FileUtils.copyInputStreamToFile(inputStream, tmpFile);
            // 上传UpYun后返回的path
            String versionGbk = AnalysisApk.unZip(tmpFile.getPath(), "")[0];
            byte[] versionNam = versionGbk.getBytes("iso8859-1");// 这里写转换前的编码方式
            newVersionName = new String(versionNam, "utf-8");// 这里写转换后的编码方式
            path = UpyunUtils.uploadApk(tmpFile,
                    multipartFile.getOriginalFilename(), true, newVersionName);
            System.err.println(path);
            tmpFile.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
        json.put("newVersionName", newVersionName);
        json.put("fileMd5", fileMd5);
        json.put("message", "应用上传成功");
        json.put("status", true);
        json.put("filePath", path);
        return json;
	
	*/
	
	JSONArray array=new JSONArray();

		 

	JSONObject lan1=new JSONObject();
		

	lan1.put("id", 1);

	lan1.put("name", "Java");

	lan1.put("ide", "Eclipse");
	
	String returnjson=lan1.toString();
	response.getWriter().write(returnjson);
	






%>

