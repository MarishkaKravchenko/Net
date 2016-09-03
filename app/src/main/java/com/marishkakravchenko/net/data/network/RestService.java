package com.marishkakravchenko.net.data.network;

import com.marishkakravchenko.net.data.network.res.ContributorModel;
import com.marishkakravchenko.net.data.network.res.ResUserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestService {

/*    @Headers({
            "Custom-Header : me header Value"
    })*/
@GET("{owner}/{repo}/master/test1.json")
Call<ResUserModel> repoContributors(
        @Path("owner") String owner,
        @Path("repo") String repo);
}
