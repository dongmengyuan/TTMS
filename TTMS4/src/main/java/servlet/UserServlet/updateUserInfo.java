package main.java.servlet.UserServlet;

import main.se.ttms.model.User;
import main.se.ttms.service.UserService;
import main.se.ttms.service.UserServiceImpl;
import main.se.util.UploadUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@WebServlet("/updateUserInfo")
public class updateUserInfo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> map = new HashedMap();

        try {

            DiskFileItemFactory factory = new DiskFileItemFactory();

            ServletFileUpload upload = new ServletFileUpload(factory);

            List<FileItem> list=upload.parseRequest(request);

            for (FileItem fileItem : list) {
                if(fileItem.isFormField()){
                    map.put(fileItem.getFieldName(), fileItem.getString("utf-8"));

                    System.out.println(fileItem.getFieldName());
                }else{
                    //获取文件名称
                    String filename = fileItem.getName();
                    System.out.println(filename.equals(""));
                    if(filename!=null&&!filename.equals("")){
                        //获取文件真实名称
                        String realName = UploadUtils.getRealName(filename);

                        //获取文件随机名称
                        String uuidName = UploadUtils.getUUIDName(realName);

                        String realPath = this.getServletContext().getRealPath("/images");

                        InputStream is = fileItem.getInputStream();
                        //保存图片
                        FileOutputStream os = new FileOutputStream(new File(realPath,uuidName));

                        IOUtils.copy(is, os);
                        os.close();
                        is.close();
                        //移除临时文件
                        fileItem.delete();
                        //在map中设置文件的路径
                        map.put(fileItem.getFieldName(), "images/"+uuidName);
                    }
                }
            }
            User user = new User();

            BeanUtils.populate(user, map);
            if(user.getHead_path()!=null){
                UserService service = new UserServiceImpl();
                User user1 = (User) request.getSession().getAttribute("user");
                user1.setHead_path(user.getHead_path());
                service.updateUserheadpath(user1);

                request.getSession().removeAttribute("user");
                request.getSession().setAttribute("user", user1);
            }

            request.getRequestDispatcher("/userInfo.jsp").forward(request, response);

            //service.updateHeadpath(employee);


        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
