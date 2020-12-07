package com.example.demo.landray.kmReviewWebserviceServiceSource_prod;

import com.alibaba.fastjson.JSON;
import com.example.demo.landray.kmReviewWebserviceServiceSource.AttachmentForm;
import com.example.demo.landray.kmReviewWebserviceServiceSource.Exception_Exception;
import com.example.demo.landray.kmReviewWebserviceServiceSource.IKmReviewWebserviceService;
import com.example.demo.landray.kmReviewWebserviceServiceSource.KmReviewParamterForm;
import com.example.demo.landray.sysNotifyTodoWebServiceSource.ISysNotifyTodoWebService;
import com.example.demo.landray.sysNotifyTodoWebServiceSource.NotifyTodoAppResult;
import com.example.demo.landray.sysNotifyTodoWebServiceSource.NotifyTodoGetContext;
import com.example.demo.landray.sysSynchroGetOrgWebServiceSource.ISysSynchroGetOrgWebService;
import com.example.demo.landray.sysSynchroGetOrgWebServiceSource.SysSynchroGetOrgBaseInfoContext;
import com.example.demo.landray.sysSynchroGetOrgWebServiceSource.SysSynchroGetOrgInfoContext;
import com.example.demo.landray.sysSynchroGetOrgWebServiceSource.SysSynchroOrgResult;
import org.apache.commons.collections.CollectionUtils;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.URLDataSource;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WebService客户端
 * 
 */
public class WebServiceClient {

	/**
	 * 主方法
	 * 
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		WebServiceConfig cfg = WebServiceConfig.getInstance("sysSynchroGetOrgWebService");
		Object service = callService(cfg.getAddress(), cfg.getServiceClass());
		ISysSynchroGetOrgWebService orgWebService = (ISysSynchroGetOrgWebService)service;
//		SysSynchroGetOrgBaseInfoContext context = new SysSynchroGetOrgBaseInfoContext();
//		context.setReturnOrgType("[{\"type\":\"person\"}]");
//		SysSynchroOrgResult elementsBaseInfo = orgWebService.getElementsBaseInfo(context);
//		System.out.println(elementsBaseInfo);
		SysSynchroGetOrgInfoContext context = new SysSynchroGetOrgInfoContext();
		context.setReturnOrgType("[{\"type\":\"person\"}]");
		context.setCount(9999);
		SysSynchroOrgResult updatedElements = orgWebService.getUpdatedElements(context);
		System.out.println(updatedElements.toString());
//		WebServiceConfig cfg = WebServiceConfig.getInstance("kmReviewWebserviceService");
//		Object service = callService(cfg.getAddress(), cfg.getServiceClass());
		// 请在此处添加业务代码
//		IKmReviewWebserviceService iKmReviewWebserviceService = (IKmReviewWebserviceService)service;
//		String id = addReview(iKmReviewWebserviceService);
//		approveProcess(iKmReviewWebserviceService, id);
//		updateReviewInfo(iKmReviewWebserviceService, "17622699fee61fb97e0d4174ccb803a8");
//		approveProcess2(iKmReviewWebserviceService, "17467b76951925b7ed501eb46d0bd9e8");


//		WebServiceConfig cfg2 = WebServiceConfig.getInstance("sysNotifyTodoWebService");
//		Object service2 = callService(cfg2.getAddress(), cfg2.getServiceClass());
//		ISysNotifyTodoWebService iSysNotifyTodoWebService = (ISysNotifyTodoWebService) service2;
//		NotifyTodoGetContext _getTodo_arg0 = new NotifyTodoGetContext();
//		_getTodo_arg0.setTargets("{\"PersonNo\": \"00005856\"}");
//		_getTodo_arg0.setType(1);
//		_getTodo_arg0.setPageNo(1);
//		_getTodo_arg0.setRowSize(10000);
//		NotifyTodoAppResult todo = iSysNotifyTodoWebService.getTodo(_getTodo_arg0);
//		if (todo != null) {
//			Message message = JSON.parseObject(todo.getMessage(), Message.class);
//			List<MessageDoc> docs = message.getDocs();
//			if (CollectionUtils.isNotEmpty(docs)) {
//				for (MessageDoc doc : docs) {
//					System.out.println(doc);
//				}
//			}
//		}
	}

	private static void updateReviewInfo(IKmReviewWebserviceService iKmReviewWebserviceService, String fdId) {
		KmReviewParamterForm _updateReviewInfo_arg0 = new KmReviewParamterForm();
		try {
			_updateReviewInfo_arg0.setFdId(fdId);
			// 文档模板id
			_updateReviewInfo_arg0.setFdTemplateId("1740bab5b0dc3c8bb2271c645989a697");
			// 文档标题
			_updateReviewInfo_arg0.setDocSubject("测试驳回1");
			// 流程发起人
			_updateReviewInfo_arg0.setDocCreator("{\"PersonNo\": \"00005856\"}");
			// 10: 草稿 20: 待审
			_updateReviewInfo_arg0.setDocStatus("20");
			// 文档关键字
//            form.setFdKeyword("[\"物料\", \"采购\"]");
			// 流程表单
//			String formValues = "{\"fd_37acfd90b47d60\":\"\", \"fd_380dcc623762ea\":\"申请人岗位\",\"fd_380e7a0afb2aac\":\"2020-08-14\"," +
//					"\"fd_37ababc482d6ea\":\"保证金\",\"fd_37ac601542818e\":\"10000005\",\"fd_37ac601542818e_text\":\"上海卓牧企业管理咨询有限公司-10000005\",\"fd_37abace0001894\":\"费用申请描述\"," +
//					"\"fd_37abacf39b2e18\":\"\",\"fd_37abacf9e4fa22\":\"0\",\"fd_37abad1334ed9a\":\"0\",\"fd_37abaf3854cb5a\":\"100\"," +
//					"\"fd_37abac621f1ddc\":\"0\",\"fd_37ac38c7101510\":\"CASH 现金\",\"fd_37abad3b63c4f8\":\"张三\",\"fd_37abaf1786ce7c\":\"6215581813000207814\"," +
//					"\"fd_37ac36653ea710\":\"\",\"fd_37ac36653ea710_text\":\"深圳市万邑通电子商务有限公司\",\"fd_380e7a370affc2\":\"A\"" +
//					",\"fd_37ad009aee2198\":\"头程相关费用\",\"fd_37ad009aee2198_text\":\"头程相关费用\",\"fd_37abaf51ab71de\":\"2020-08-14\",\"fd_37abacee886828\":\"202008\"" +
//					",\"fd_37abacf8b7bfec\":\"45678\",\"fd_37abacfaee0ba8\":\"200\",\"fd_37abad171a4670\":\"0\",\"fd_38d303859e135c\":\"PR2020091815123456\"," +
//					"\"fd_37abac2478b68e\":\"\",\"fd_37abac2478b68e_text\":\"\",\"fd_37ad099417f644\":\"0\",\"fd_37abad2de644b8\":\"456789\"," +
//					"\"fd_37abad2f5135b4\":\"工商银行\",\"fd_37abad3080c548\":\"收款银行地址\"," +
//					"\"fd_37ac3c7b8ae23a.fd_37ac3db2fe7ef8\":[\"2020-08-24\",\"2020-08-24\"]," +
//					"\"fd_37ac3c7b8ae23a.fd_37ac3db3ee22f8\":[\"2020-08-24\",\"2020-08-24\"]," +
//					"\"fd_37ac3c7b8ae23a.fd_37ac5ef3d5b02e\":[\"入库处理费\",\"目的港THC\"]," +
//					"\"fd_37ac3c7b8ae23a.fd_37ac5ef3d5b02e_text\":[\"入库处理费\",\"目的港THC\"]," +
//					"\"fd_37ac3c7b8ae23a.fd_37ac3dab514192\":[\"100\",\"10\"]" +
//					"}";
//			_updateReviewInfo_arg0.setFormValues(formValues);
			// 流程参数
//                String flowParam = "{auditNode:\"请审核\", futureNodeId:\"N75\", changeNodeHandlers:[\"N75:17370a85e82dedba2d42fae406f8df11;17370a85f8f573fbfebf22f4a2eac7f0\"]}";
//                _updateReviewInfo_arg0.setFlowParam(flowParam);

                List<AttachmentForm> attForms = createAllAtts();
                _updateReviewInfo_arg0.getAttachmentForms().addAll(attForms);
			String _updateReviewInfo__return = iKmReviewWebserviceService.updateReviewInfo(_updateReviewInfo_arg0);
			System.out.println("updateReviewInfo.result=" + _updateReviewInfo__return);

		} catch (Exception_Exception e) {
			System.out.println("Expected exception: Exception has occurred.");
			System.out.println(e.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void approveProcess2(IKmReviewWebserviceService iKmReviewWebserviceService, String id) throws Exception {
		KmReviewParamterForm _approveProcess_arg0 = new KmReviewParamterForm();
		_approveProcess_arg0.setDocSubject("测试驳回1");
		_approveProcess_arg0.setFdId(id);
		_approveProcess_arg0.setFdTemplateId("1740bab5b0dc3c8bb2271c645989a697");
//		 _approveProcess_arg0.setFdKeyword();
//		_approveProcess_arg0.setDocStatus("20");
		_approveProcess_arg0.setDocCreator("{\"PersonNo\": \"00005856\"}");
		// 流程表单
		String formValues = "{\"fd_37acfd90b47d60\":\"职能部门\", \"fd_380dcc623762ea\":\"申请人岗位\",\"fd_380e7a0afb2aac\":\"2020-08-14\"," +
				"\"fd_37ababc482d6ea\":\"保证金\",\"fd_37ac601542818e\":\"10000005\",\"fd_37ac601542818e_text\":\"上海卓牧企业管理咨询有限公司-10000005\",\"fd_37abace0001894\":\"费用申请描述\"," +
				"\"fd_37abacf39b2e18\":\"100\",\"fd_37abacf9e4fa22\":\"0\",\"fd_37abad1334ed9a\":\"0\",\"fd_37abaf3854cb5a\":\"100\"," +
				"\"fd_37abac621f1ddc\":\"0\",\"fd_37ac38c7101510\":\"CASH 现金\",\"fd_37abad3b63c4f8\":\"张三\",\"fd_37abaf1786ce7c\":\"6215581813000207814\"," +
				"\"fd_37ac36653ea710\":\"深圳市万邑通电子商务有限公司\",\"fd_37ac36653ea710_text\":\"深圳市万邑通电子商务有限公司\",\"fd_380e7a370affc2\":\"A\"" +
				",\"fd_37ad009aee2198\":\"头程相关费用\",\"fd_37ad009aee2198_text\":\"头程相关费用\",\"fd_37abaf51ab71de\":\"2020-08-14\",\"fd_37abacee886828\":\"202008\"" +
				",\"fd_37abacf8b7bfec\":\"123456\",\"fd_37abacfaee0ba8\":\"100\",\"fd_37abad171a4670\":\"0\"," +
				"\"fd_37abac2478b68e\":\"人民币-CNY\",\"fd_37abac2478b68e_text\":\"人民币-CNY\",\"fd_37ad099417f644\":\"0\",\"fd_37abad2de644b8\":\"456789\"," +
				"\"fd_37abad2f5135b4\":\"工商银行\",\"fd_37abad3080c548\":\"收款银行地址\"," +
				"\"fd_37ac3c7b8ae23a.fd_37ac3db2fe7ef8\":[\"2020-08-24\",\"2020-08-24\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac3db3ee22f8\":[\"2020-08-24\",\"2020-08-24\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac5ef3d5b02e\":[\"入库处理费\",\"目的港THC\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac5ef3d5b02e_text\":[\"入库处理费\",\"目的港THC\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac3dab514192\":[\"100\",\"0\"]" +
				"}";
		_approveProcess_arg0.setFormValues(formValues);
		String flowParam = "{operationType:\"handler_pass\", auditNode:\"请审核\"}";
//		String flowParam = "{operationType:\"handler_pass\", auditNode:\"请审核\", futureNodeId:\"N75\", changeNodeHandlers:[\"N75:17370a85e82dedba2d42fae406f8df11\"]}";
		_approveProcess_arg0.setFlowParam(flowParam);
		// 附件
		List<AttachmentForm> attForms = createAllAtts();
		_approveProcess_arg0.getAttachmentForms().addAll(attForms);

//		String flowParam = "{operationType:\"handler_refuse\",auditNode:\"拒绝\", futureNodeId:\"N2\"}";
//		_approveProcess_arg0.setFlowParam(flowParam);

		String _approveProcess__return = iKmReviewWebserviceService.updateReviewInfo(_approveProcess_arg0);
		System.out.println("approveProcess.result=" + _approveProcess__return);
	}

	private static void approveProcess(IKmReviewWebserviceService iKmReviewWebserviceService, String id) throws Exception {
		KmReviewParamterForm _approveProcess_arg0 = new KmReviewParamterForm();
		_approveProcess_arg0.setDocSubject("测试驳回1");
		_approveProcess_arg0.setFdId(id);
		_approveProcess_arg0.setFdTemplateId("1740bab5b0dc3c8bb2271c645989a697");
//		 _approveProcess_arg0.setFdKeyword();
//		_approveProcess_arg0.setDocStatus("20");
		_approveProcess_arg0.setDocCreator("{\"PersonNo\": \"00005856\"}");
		// 流程表单
		String formValues = "{\"fd_37acfd90b47d60\":\"职能部门11\", \"fd_380dcc623762ea\":\"申请人岗位\",\"fd_380e7a0afb2aac\":\"2020-08-14\"," +
				"\"fd_37ababc482d6ea\":\"保证金\",\"fd_37ac601542818e\":\"10000005\",\"fd_37ac601542818e_text\":\"上海卓牧企业管理咨询有限公司-10000005\",\"fd_37abace0001894\":\"费用申请描述\"," +
				"\"fd_37abacf39b2e18\":\"100\",\"fd_37abacf9e4fa22\":\"0\",\"fd_37abad1334ed9a\":\"0\",\"fd_37abaf3854cb5a\":\"100\"," +
				"\"fd_37abac621f1ddc\":\"0\",\"fd_37ac38c7101510\":\"CASH 现金\",\"fd_37abad3b63c4f8\":\"张三\",\"fd_37abaf1786ce7c\":\"6215581813000207814\"," +
				"\"fd_37ac36653ea710\":\"深圳市万邑通电子商务有限公司\",\"fd_37ac36653ea710_text\":\"深圳市万邑通电子商务有限公司\",\"fd_380e7a370affc2\":\"A\"" +
				",\"fd_37ad009aee2198\":\"头程相关费用\",\"fd_37ad009aee2198_text\":\"头程相关费用\",\"fd_37abaf51ab71de\":\"2020-08-14\",\"fd_37abacee886828\":\"202008\"" +
				",\"fd_37abacf8b7bfec\":\"123456\",\"fd_37abacfaee0ba8\":\"100\",\"fd_37abad171a4670\":\"0\"," +
				"\"fd_37abac2478b68e\":\"人民币-CNY\",\"fd_37abac2478b68e_text\":\"人民币-CNY\",\"fd_37ad099417f644\":\"0\",\"fd_37abad2de644b8\":\"456789\"," +
				"\"fd_37abad2f5135b4\":\"工商银行\",\"fd_37abad3080c548\":\"收款银行地址\",\"fd_380dcb08f8e28e\":\"RP123456\"," +
				"\"fd_37ac3c7b8ae23a.fd_37ac3db2fe7ef8\":[\"2020-08-24\",\"2020-08-24\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac3db3ee22f8\":[\"2020-08-24\",\"2020-08-24\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac5ef3d5b02e\":[\"入库处理费\",\"目的港THC\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac5ef3d5b02e_text\":[\"入库处理费\",\"目的港THC\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac3dab514192\":[\"100\",\"0\"]" +
				"}";
		_approveProcess_arg0.setFormValues(formValues);
		String flowParam = "{operationType:\"handler_pass\", auditNode:\"请审核\"}";
//		String flowParam = "{operationType:\"handler_pass\", auditNode:\"请审核\", futureNodeId:\"N75\", changeNodeHandlers:[\"N75:17370a85e82dedba2d42fae406f8df11\"]}";
		_approveProcess_arg0.setFlowParam(flowParam);
		// 附件
		List<AttachmentForm> attForms = createAllAtts();
		_approveProcess_arg0.getAttachmentForms().addAll(attForms);

//		String flowParam = "{operationType:\"handler_refuse\",auditNode:\"拒绝\", futureNodeId:\"N2\"}";
//		_approveProcess_arg0.setFlowParam(flowParam);

		String _approveProcess__return = iKmReviewWebserviceService.approveProcess(_approveProcess_arg0);
		System.out.println("approveProcess.result=" + _approveProcess__return);
	}

	private static String addReview(IKmReviewWebserviceService iKmReviewWebserviceService) throws Exception {
		KmReviewParamterForm form = new KmReviewParamterForm();
		// 文档模板id
		form.setFdTemplateId("1740bab5b0dc3c8bb2271c645989a697");
		// 文档标题
		form.setDocSubject("测试驳回1");
		// 流程发起人
		form.setDocCreator("{\"PersonNo\": \"00005856\"}");
		// 10: 草稿 20: 待审
		form.setDocStatus("20");
		// 流程表单
		String formValues = "{\"fd_38100018d42cce\":\"16ab94a385c324ad363199a46c79965f\", \"fd_37acfd90b47d60\":\"职能部门11\", \"fd_380dcc623762ea\":\"申请人岗位\",\"fd_380e7a0afb2aac\":\"2020-08-14\"," +
				"\"fd_37ababc482d6ea\":\"保证金\",\"fd_37ac601542818e\":\"10000005\",\"fd_37ac601542818e_text\":\"上海卓牧企业管理咨询有限公司-10000005\",\"fd_37abace0001894\":\"费用申请描述\"," +
				"\"fd_37abacf39b2e18\":\"100\",\"fd_37abacf9e4fa22\":\"0\",\"fd_37abad1334ed9a\":\"0\",\"fd_37abaf3854cb5a\":\"100\"," +
				"\"fd_37abac621f1ddc\":\"0\",\"fd_37ac38c7101510\":\"CASH 现金\",\"fd_37abad3b63c4f8\":\"张三\",\"fd_37abaf1786ce7c\":\"6215581813000207814\"," +
				"\"fd_37ac36653ea710\":\"深圳市万邑通电子商务有限公司\",\"fd_37ac36653ea710_text\":\"深圳市万邑通电子商务有限公司\",\"fd_380e7a370affc2\":\"A\"" +
				",\"fd_37ad009aee2198\":\"头程相关费用\",\"fd_37ad009aee2198_text\":\"头程相关费用\",\"fd_37abaf51ab71de\":\"2020-08-14\",\"fd_37abacee886828\":\"202008\"" +
				",\"fd_37abacf8b7bfec\":\"123456\",\"fd_37abacfaee0ba8\":\"100\",\"fd_37abad171a4670\":\"0\",\"fd_38d303859e135c\":\"PR202012071212321237\"," +
				"\"fd_37abac2478b68e\":\"人民币-CNY\",\"fd_37abac2478b68e_text\":\"人民币-CNY\",\"fd_37ad099417f644\":\"0\",\"fd_37abad2de644b8\":\"456789\"," +
				"\"fd_37abad2f5135b4\":\"工商银行\",\"fd_37abad3080c548\":\"收款银行地址\",\"fd_380dcb08f8e28e\":\"RP1212121212\"," +
				"\"fd_37ac3c7b8ae23a.fd_37ac3db2fe7ef8\":[\"2020-08-24\",\"2020-08-24\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac3db3ee22f8\":[\"2020-08-24\",\"2020-08-24\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac5ef3d5b02e\":[\"入库处理费\",\"目的港THC\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac5ef3d5b02e_text\":[\"入库处理费\",\"目的港THC\"]," +
				"\"fd_37ac3c7b8ae23a.fd_37ac3dab514192\":[\"100\",\"0\"]" +
				"}";
		form.setFormValues(formValues);
		String flowParam = "{operationType:\"handler_pass\", auditNode:\"请审核\"}";
		form.setFlowParam(flowParam);
//		// 附件
		List<AttachmentForm> attForms = createAllAtts();
		form.getAttachmentForms().addAll(attForms);
		String _addReview__return = iKmReviewWebserviceService.addReview(form);
		System.out.println("addReview.result=" + _addReview__return);
		return _addReview__return;
	}
	
	/**
	 * 调用服务，生成客户端的服务代理
	 * 
	 * @param address WebService的URL
	 * @param serviceClass 服务接口全名
	 * @return 服务代理对象
	 * @throws Exception
	 */
	public static Object callService(String address, Class serviceClass)
			throws Exception {

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		// 记录入站消息
		factory.getInInterceptors().add(new LoggingInInterceptor());
		
		// 记录出站消息
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		
		// 添加消息头验证信息。如果服务端要求验证用户密码，请加入此段代码
//		 factory.getOutInterceptors().add(new AddSoapHeader());

		factory.setServiceClass(serviceClass);
		factory.setAddress(address);
		
		// 使用MTOM编码处理消息。如果需要在消息中传输文档附件等二进制内容，请加入此段代码
		// Map<String, Object> props = new HashMap<String, Object>();
		// props.put("mtom-enabled", Boolean.TRUE);
		// factory.setProperties(props);		
        
        // 创建服务代理并返回
		return factory.create();
	}

	/**
	 * 创建附件列表
	 */
	static List<AttachmentForm> createAllAtts() throws Exception {

		List<AttachmentForm> attForms = new ArrayList<AttachmentForm>();

		String fileName = "31AE88-201802.xlsx";
		AttachmentForm attForm01 = createUrlFile(fileName);
		fileName = "测试.docx";
		AttachmentForm attForm02 = createAtt(fileName);

		attForms.add(attForm01);
		attForms.add(attForm02);

		return attForms;
	}

	/**
	 * 创建附件对象
	 */
	static AttachmentForm createAtt(String fileName) throws Exception {
		AttachmentForm attForm = new AttachmentForm();
		attForm.setFdFileName(fileName);
		// 设置附件关键字，表单模式下为附件控件的id
		attForm.setFdKey("fd_37cee0c4b3da46");
		DataSource dataSource = new FileDataSource("C:\\Users\\ming.zhang2\\Desktop\\" + fileName);
		DataHandler dataHandler = new DataHandler(dataSource);
		attForm.setFdAttachment(dataHandler);

		return attForm;
	}

	/**
	 * 创建Url
	 */
	static AttachmentForm createUrlFile(String fileName) throws Exception {
		AttachmentForm attForm = new AttachmentForm();
		attForm.setFdFileName(fileName);
		// 设置附件关键字，表单模式下为附件控件的id
		attForm.setFdKey("fd_37cee0c4b3da46");
		URL url = new URL("http://files.winit.com.cn/uploads/ftp/account_ftp/2018/ups/original_bill/31AE88-201802.xlsx");
		DataSource dataSource = new URLDataSource(url);
		DataHandler dataHandler = new DataHandler(dataSource);
		attForm.setFdAttachment(dataHandler);
		return attForm;
	}
}
