package com.oldVK.main.dao;

import com.oldVK.main.models.Post;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.util.List;

public class PostJdbcDao extends JdbcDaoSupport implements PostDao {
    public PostJdbcDao(DataSource dataSource) {
        super();
        setDataSource(dataSource);
        String initSqlPosts = "CREATE TABLE IF NOT EXISTS POST " +
                "(ID INTEGER primary key AUTOINCREMENT not null, " +
                "OWNER_ID INT not null, " +
                "AUTHOR_ID INT not null, " +
                "MESSAGE TEXT not null);";
        getJdbcTemplate().update(initSqlPosts);
    }

    @Override
    public List<Post> getPosts(int owner_id) {
        String sql = "SELECT * FROM POST" +
                "WHERE owner_id = \"" +
                owner_id +
                "\";";
        return getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Post.class));
    }

}
