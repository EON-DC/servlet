package hello.servlet.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() throws Exception {
        //given
        Member member = new Member("hello", 20);
        //when
        Member savedMember = memberRepository.save(member);

        //then
        Member findMember = memberRepository.findById(member.getId());
        assertThat(savedMember).isEqualTo(savedMember);
    }

    @Test
    public void findAll() throws Exception {
        //given
        Member member1 = new Member("hello", 20);
        Member member2 = new Member("goot", 25);

        //when

        memberRepository.save(member1);
        memberRepository.save(member2);

        //then
        assertThat(memberRepository.findAll().size()).isEqualTo(2);
        assertThat(memberRepository.findAll()).contains(member1, member2);

    }
}