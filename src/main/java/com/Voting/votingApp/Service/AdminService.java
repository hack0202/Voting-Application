package com.Voting.votingApp.Service;

import org.springframework.web.bind.annotation.RequestBody;

import com.Voting.votingApp.DtoBean.AdminDtoBean;

public interface AdminService {
public String saveAdmin(@RequestBody AdminDtoBean adminDtoBean);
}
