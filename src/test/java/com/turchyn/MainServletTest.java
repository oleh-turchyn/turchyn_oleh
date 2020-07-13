package com.turchyn;

import com.turchyn.usermanagement.webs.MainServlet;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MainServletTest {
    private String path = "Tour.jsp";
    static HttpServletRequest request;
    static HttpServletResponse response;
    static RequestDispatcher dispatcher;
    static MainServlet servlet = new MainServlet();
    @BeforeAll
    public static void createServlet(){
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
    }

    @Test
    public  void doPost() throws Exception{
        servlet.doPost(request,response);
    }

    @Test
    public void call() throws ServletException, IOException {

        final MainServlet servlet = new MainServlet();

//        final HttpServletRequest request =
//        final HttpServletResponse response =
//        final RequestDispatcher dispatcher =
        String action = request.getServletPath();
        if (action.equals("/tour")){
            when(request.getRequestDispatcher(path)).thenReturn(dispatcher);
            servlet.doGet(request,response);
            verify(request,times(1)).getRequestDispatcher(path);
            verify(request,never()).getSession();
            verify(dispatcher).forward(request,response);
        }


    }
}
