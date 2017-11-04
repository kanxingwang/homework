package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.People;
import service.PeopleService;
import service.PeopleServiceImpl;

@WebServlet("/PeopleServlet")
public class PeopleServlet extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	public static final String QUERY_All="queryAll";
	public static final String UPDARE="update";
	public static final String DELETE="delete";
	public static final String QUERY_BY_ID="queryById";
	public static final String TO_ADD="toAdd";
	
	private PeopleService peopleService;

	/**
	 * ����get����,����ҳ��Ĳ�������ҳ����
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    //���ñ��뼰���ظ�ʽ
	    request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        
        //ҳ��Ĳ�������ҳ����
		String type=request.getParameter("type");
		PrintWriter out = response.getWriter();
		String pageString="";
        switch (type) {
        case TO_ADD:
            pageString = toAdd(request, response);
            break;
        case UPDARE:
            pageString = doUpdate(request, response);
            break;
        case DELETE:
            pageString = doDeleteById(request, response);
            break;
        case QUERY_BY_ID:
            pageString = doQueryById(request, response);
            break;
        default:
            pageString = doQueryAll(request, response);
            break;
        }
		out.println(pageString);
		out.flush();
	}
	/*
	 * ��������
	 */
	private String toAdd(HttpServletRequest request,HttpServletResponse response) {
		People p = new People();
		peopleService.insertData(p);
	    String pageString="";
	    pageString+="<html lang='en'><head><meta charset='UTF-8'><title>�����û�</title></head> "+
	    "<body><div align='center' style='width: 400px; position: relative;left:450px'><form action='/HRMS/PeopleServlet?type=TO_ADD'>"+
	    		"<h4>�����û�</h4> ����: <input type='text' name='name'><input type='hidden' name='type' value='insertData'><br /> <br /> ����: <input type='text' name='age'><br /> <br /><input type='submit' value='�ύ'/>  <input type='reset' value='����'/></form></div>  </body></html>";
        return pageString;
    }
	/*
	 * ��ҳ�� ��ʾ���й���
	 */
    public String doQueryAll(HttpServletRequest request, HttpServletResponse response) {
       List<People> pList=peopleService.queryAllData(); 
       
       String pageString="";
       if(pList!=null&&pList.size()>0){
           pageString+="<html lang='en'><head><meta charset='UTF-8'><title>HRMS</title></head>"+
                   " <body><div align='center'style='width: 400px; position: relative;left:450px;'>"+
                   "<form action='ListPeople' ><table border='1' cellspacing='0'> <tr><th>���</th>"+
                   "<th>����</th><th>����</th><th>����</th> </tr>";
       }
       for( int i = 0 ; i < pList.size()-1 ; i++) {
           People people=pList.get(i);
           pageString+=" <tr><td>"+people.getId()+"</td><td>"+people.getName()+"</td><td>"+people.getAge()+"</td><td>"+
           "<a href= '/HRMS/PeopleServlet?type=UPDARE&id=<%=people.getId()%>'   style='text-decoration:none'>�޸�&nbsp;</a>"+
        		   "<a href= '/HRMS/PeopleServlet?type=DELETE&id=<%=people.getId()%>'   style='text-decoration:none'>ɾ��</a></td></tr>";
       }
       pageString+= " </table><div > <a href= '/HRMS/PeopleServlet?type=TO_ADD'   style='text-decoration:none'>����&nbsp;</a>"+
       "<a href= '/HRMS/PeopleServlet?type=QUERY_BY_ID'   style='text-decoration:none'>����id��ѯ</a>  </div></form></div></body></html>";
        return pageString;
    }
	/*
	 * ����id��ѯ��Ϣ
	 */
	private String doQueryById(HttpServletRequest request,
            HttpServletResponse response) {
		People p = new People();
		peopleService.queryDataById(p.getId()); 
		String pageString="";
		pageString+="<html lang='en'><head><meta charset='UTF-8'><title>��ѯҳ��</title></head>" + 
				"<body><div align='center' style='width: 400px; position: relative;left:450px'><form action='/HRMS/PeopleServlet?type=QUERY_BY_ID'>" + 
				"<h4>��ѯ</h4> ������id: <input type='text' name='id'><input type='hidden' name='type' value='doQueryById'><br /> <br />  </form></div><br> ��ѯ���������"+
				p.getName()+"���䣺"+p.getAge()+"  </body></html>" ;
        
        return pageString;
    }
	/*
	 * ���²���
	 */
    public String doUpdate(HttpServletRequest request,
            HttpServletResponse response) {
    	People p =(People)request.getAttribute("people");
    	if(p!= null)
        	peopleService.update(p);
    	String pageString="";
    	pageString+="<html lang='en'><head><meta charset='UTF-8'><title>�޸��û�</title></head> <body><div align='center' style='width: 400px; position: relative;left:450px'><form action='/HRMS/PeopleServlet?'>"+
    	"<h4>�޸��û�</h4> ����: <input type='text' name='name' value='siafr'><input type='hidden' name='type' value='doUpdate'><input type='hidden' name='id' value='5'><br /> <br /> "+
    			"����: <input type='text' name='age' value='24'><br /> <br /><input type='submit' value='ȷ��'/></form></div>  </body></html>" ;
    	
        return null;
    }
    /*
     * ɾ������
     */
	public String doDeleteById(HttpServletRequest request,
            HttpServletResponse response) {
		People p = new People();
		peopleService.delete(p.getId());
        return null;
    }


	public PeopleServlet() {
	    peopleService=new PeopleServiceImpl();
    }

	

}