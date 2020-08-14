package com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2020-08-14T15:24:33.755+08:00
 * Generated source version: 2.4.2
 * 
 */
@WebService(targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", name = "ISysNotifyTodoWebService")
@XmlSeeAlso({ObjectFactory.class})
public interface ISysNotifyTodoWebService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "updateTodo", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.UpdateTodo")
    @WebMethod
    @ResponseWrapper(localName = "updateTodoResponse", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.UpdateTodoResponse")
    public NotifyTodoAppResult updateTodo(
            @WebParam(name = "arg0", targetNamespace = "")
                    NotifyTodoUpdateContext arg0
    ) throws Exception_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "setTodoDone", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.SetTodoDone")
    @WebMethod
    @ResponseWrapper(localName = "setTodoDoneResponse", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.SetTodoDoneResponse")
    public NotifyTodoAppResult setTodoDone(
            @WebParam(name = "arg0", targetNamespace = "")
                    NotifyTodoRemoveContext arg0
    ) throws Exception_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getTodo", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.GetTodo")
    @WebMethod
    @ResponseWrapper(localName = "getTodoResponse", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.GetTodoResponse")
    public NotifyTodoAppResult getTodo(
            @WebParam(name = "arg0", targetNamespace = "")
                    NotifyTodoGetContext arg0
    ) throws Exception_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "getTodoCount", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.GetTodoCount")
    @WebMethod
    @ResponseWrapper(localName = "getTodoCountResponse", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.GetTodoCountResponse")
    public NotifyTodoAppResult getTodoCount(
            @WebParam(name = "arg0", targetNamespace = "")
                    NotifyTodoGetCountContext arg0
    ) throws Exception_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "deleteTodo", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.DeleteTodo")
    @WebMethod
    @ResponseWrapper(localName = "deleteTodoResponse", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.DeleteTodoResponse")
    public NotifyTodoAppResult deleteTodo(
            @WebParam(name = "arg0", targetNamespace = "")
                    NotifyTodoRemoveContext arg0
    ) throws Exception_Exception;

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sendTodo", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.SendTodo")
    @WebMethod
    @ResponseWrapper(localName = "sendTodoResponse", targetNamespace = "http://webservice.notify.sys.kmss.landray.com/", className = "com.example.demo.landray.com.landray.kmss.sysNotifyTodoWebServiceSource.SendTodoResponse")
    public NotifyTodoAppResult sendTodo(
            @WebParam(name = "arg0", targetNamespace = "")
                    NotifyTodoSendContext arg0
    ) throws Exception_Exception;
}
