package com.app.library.utils.log;

class LogInfo {

	private String content;
	private String fileName;

	/**
	 * 
	 * @param content
	 *            内容
	 * @param fileName
	 *            文件名
	 */
	public LogInfo(String content, String fileName) {
		this.content = content;
		this.fileName = fileName;
	}

	/**
	 * 内容
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 获取文件名
	 * 
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}
}
