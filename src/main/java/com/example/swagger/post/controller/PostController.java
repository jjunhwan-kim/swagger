package com.example.swagger.post.controller;

import com.example.swagger.global.CommonResponse;
import com.example.swagger.post.request.PostCreateRequest;
import com.example.swagger.post.request.PostUpdateRequest;
import com.example.swagger.post.response.PostCreateResponse;
import com.example.swagger.post.response.PostListReadResponse;
import com.example.swagger.post.response.PostReadResponse;
import com.example.swagger.post.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Post", description = "Post API")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    @Operation(summary = "게시글 목록 조회", description = "게시글 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공")
    @ApiResponse(responseCode = "400", description = "파라미터 오류")
    public CommonResponse<PostListReadResponse> getPosts(
            @Parameter(description = "페이지 번호, 0부터 시작")
            @RequestParam(required = false) Integer page,
            @Parameter(description = "한 페이지의 데이터 개수")
            @RequestParam(required = false) Integer size,
            @Parameter(description = "정렬 파라미터, 오름차순 또는 내림차순 ex) createdDate,asc(작성일 오름차순), createdDate,desc(작성일 내림차순)")
            @RequestParam(required = false) String sort) {
        return CommonResponse.success(postService.getPosts(page, size, sort));
    }

    @GetMapping("/posts/{id}")
    @Operation(summary = "게시글 조회", description = "게시글 하나를 조회합니다.")
    @ApiResponse(responseCode = "200", description = "성공")
    @ApiResponse(responseCode = "400", description = "파라미터 오류")
    public CommonResponse<PostReadResponse> getPost(
            @Parameter(required = true, description = "게시글 고유 번호")
            @PathVariable Long id) {
        return CommonResponse.success(postService.getPost(id));
    }

    @PostMapping("/posts")
    @Operation(summary = "게시글 생성", description = "게시글 하나를 생성합니다.")
    @ApiResponse(responseCode = "200", description = "성공")
    @ApiResponse(responseCode = "400", description = "파라미터 오류")
    public CommonResponse<PostCreateResponse> createPost(
            @Parameter(required = true, description = "게시글 생성 요청")
            @RequestBody
            PostCreateRequest request) {

        return CommonResponse.success(postService.createPost(request));
    }

    @PutMapping("/posts/{id}")
    @Operation(summary = "게시글 업데이트", description = "게시글 하나를 업데이트합니다.")
    @ApiResponse(responseCode = "200", description = "성공")
    @ApiResponse(responseCode = "400", description = "파라미터 오류")
    public CommonResponse<Void> updatePost(
            @Parameter(required = true, description = "게시글 고유 번호")
            @PathVariable Long id,
            @Parameter(required = true, description = "게시글 업데이트 요청")
            @RequestBody
            PostUpdateRequest request) {

        postService.updatePost(id, request);
        return CommonResponse.success();
    }

    @DeleteMapping("/posts/{id}")
    @Operation(summary = "게시글 삭제", description = "게시글 하나를 삭제합니다.")
    @ApiResponse(responseCode = "200", description = "성공")
    @ApiResponse(responseCode = "400", description = "파라미터 오류")
    public CommonResponse<PostReadResponse> deletePost(
            @PathVariable
            @Parameter(required = true, description = "게시글 고유 번호")
            Long id) {

        postService.deletePost(id);
        return CommonResponse.success();
    }
}
