package top.nju.iznauy.dao.daoImpl.forum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import top.nju.iznauy.dao.CourseForumDao;
import top.nju.iznauy.entity.Pair;
import top.nju.iznauy.exception.ServerUnknownException;
import top.nju.iznauy.po.courseforum.CoursePostPO;
import top.nju.iznauy.po.courseforum.CourseReplyPO;

import java.util.List;

/**
 * Created on 07/02/2019.
 * Description:
 *
 * @author iznauy
 */
@Slf4j
@Repository
public class CourseForumDaoImpl implements CourseForumDao {

    private CoursePostRepository postRepository;

    private CourseReplyRepository replyRepository;

    // 帖子的排序是按照最后更新时间来排序的
    @Override
    public Pair<List<CoursePostPO>, Integer> getCoursePosts(int courseId, int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "changeTime"));
        Page<CoursePostPO> resultPage = postRepository.findAll((e0, e1, e2) -> {
            e1.where(e2.equal(e0.<Integer>get("courseId"), courseId));
            return null;
        }, pageRequest);
        return new Pair<>(resultPage.getContent(), resultPage.getTotalPages());
    }

    // 帖子的回复贴是按照时间顺序排的
    @Override
    public Pair<List<CourseReplyPO>, Integer> getPostReplies(int replyTo, int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.ASC, "createTime"));
        Page<CourseReplyPO> resultPage = replyRepository.findAll((e0, e1, e2) -> {
            e1.where(e2.equal(e0.<Integer>get("replyTo"), replyTo));
            return null;
        }, pageRequest);
        return new Pair<>(resultPage.getContent(), resultPage.getTotalPages());
    }

    @Override
    public void savePost(CoursePostPO postPO) {
        postRepository.save(postPO);
    }

    @Override
    public void saveReply(CourseReplyPO replyPO) {
        int coursePost = replyPO.getReplyTo();
        CoursePostPO postPO = postRepository.findById(coursePost).orElse(null);
        if (postPO == null)
            throw new ServerUnknownException("回复的帖子不存在");
        postPO.addReply();
        postRepository.save(postPO);
        replyRepository.save(replyPO);
    }

    @Override
    public CoursePostPO getCoursePostById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    @Autowired
    public void setPostRepository(CoursePostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Autowired
    public void setReplyRepository(CourseReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }
}
