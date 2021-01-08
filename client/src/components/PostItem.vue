<template>
<div>{{post.author}}: {{post.text}}</div>
</template>

<script>
export default {
name: "PostItem",
  props: {
    post: {
      type: Object,
      required: true
    },
    index: Number
  }
}
</script>

<style scoped>

</style>