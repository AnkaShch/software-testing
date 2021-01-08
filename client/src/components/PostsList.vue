<template>
  <div class="post">
    <div v-if="posts" class="content" :key="posts.id">
      <PostItem
          v-for="(post,i) of posts"
          v-bind:post="post"
          v-bind:key="post"
          v-bind:index="i"
      />
    </div>
  </div>
</template>

<script>

import {getPosts} from "@/store/modules/post";
import PostItem from "@/components/PostItem";

export default {
  data() {
    return {
      posts: []
    }
  },
  components: {
    PostItem
  },
  created() {
    this.fetchData()
  },
  watch: {
    '$route': 'fetchData'
  },
  methods: {
    fetchData() {
      getPosts(this.$route.params.id, (err, post) => {
          this.posts.push(post)
      })
    }
  }
}
</script>

<style>
</style>