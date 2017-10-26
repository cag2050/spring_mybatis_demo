import com.yihaomen.mybatis.inter.IUserOperation;
import com.yihaomen.mybatis.model.Article;
import com.yihaomen.mybatis.model.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringMybatisTest {
    private static ApplicationContext applicationContext;

    static {
        applicationContext = new ClassPathXmlApplicationContext("config/applicationContext.xml");
    }
    public static void main(String[] args) {
        IUserOperation mapper = (IUserOperation)applicationContext.getBean("userMapper");
        System.out.println("得到用户id=1的用户信息：");
        User user = mapper.selectUserByID(1);
        System.out.println("user address: " + user.getUserAddress());
        System.out.println("得到用户id为1的所有文章列表:");
        List<Article> articles = mapper.getUserArticles(1);
        for(Article article :articles) {
            System.out.println("article.title = " + article.getTitle());
        }
    }
}
