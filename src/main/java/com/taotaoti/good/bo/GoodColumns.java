package com.taotaoti.good.bo;

/**
 * 
 * @author liulxiang
 * 
 */

public class GoodColumns {
	public final static String goodId = "id";
	public final static String categoryId = "category_id";
	public final static String name = "name";
	public final static String title = "title";
	public final static String description = "description";
	public final static String clickSum = "click_sum";
	public final static String logo = "logo";
	public final static String statu = "statu";
	public final static String memberId = "member_id";
	public final static String price = "price";
	public final static String level = "level";
	public final static String createTime = "create_time";
	public final static String updateTime = "update_time";
	
	public final static class GoodCommentColumns{
		public final static String goodCommentId = "id";
		public final static String memberId = "member_id";
		public final static String goodId = "good_id";
		public final static String content = "content";
		public final static String statu="statu";
		public final static String createTime="create_time";
		
		public final static String replyMemberId="reply_member_id";
		public final static String isReply="is_reply";
		public final static String replyContent="reply_content";
		public final static String replyTime="reply_time";
		
	}
	public final static class GoodPicColumns{
		public final static String goodPicId = "id";
		public final static String goodId = "good_id";
		public final static String path = "path";
		public final static String statu="statu";
		public final static String description="description";
		public final static String title="title";
		
		
	}
	
}
