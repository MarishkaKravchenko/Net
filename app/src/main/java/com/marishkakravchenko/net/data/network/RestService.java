package com.marishkakravchenko.net.data.network;

import com.marishkakravchenko.net.data.network.req.Contributor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestService {

/*    @Headers({
            "Custom-Header : me header Value"
    })*/
@GET("repos/{owner}/{repo}/contributors")
Call<List<Contributor>> repoContributors(
        @Path("owner") String owner,
        @Path("repo") String repo);

}
