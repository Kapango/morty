package com.kapango.morty.api;

public interface PostmortemApi {


    Postmortem getPostmortem(String id);

    Postmortem createPostmortem(Postmortem request);


}
