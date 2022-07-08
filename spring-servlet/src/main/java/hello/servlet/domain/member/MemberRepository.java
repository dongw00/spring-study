package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 동시성 고려 X, 실무에서 ConcurrencyHashMap, AtomicLong 사용 고려
public class MemberRepository {

    private static final MemberRepository instance = new MemberRepository();
    private static final Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;

    // 외부에서 기본 생성자 생성 방지
    private MemberRepository() {

    }

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
