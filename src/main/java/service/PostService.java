package service;

import model.Post;

import java.util.List;

public class PostService {
    private static final List<Post> posts = List.of(
            new Post("title1","author 1", "content 1"),
            new Post("title2","author 2", "content 2"),
            new Post("title3","author 3", "content 3"),
            new Post("title4","author 4", "content 4")
    );
    public List<Post> fetchPosts(){
        return posts;
    }

}
