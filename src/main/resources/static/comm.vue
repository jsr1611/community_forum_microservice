<template>
<div class="row">

  <div class="col-md-9 col-sm-9">   <!-- BODY-->
  <div class="m-3 p-3 bg-white">
    <div class="row">
      <div class="col-md-9 col-sm-9">
        <div class="row my-2">
          <h3>General</h3>
        </div>
        <div class="row my-2 ml-0">
          Lorem ipsum dolor sit amet consectetur adipisicing elit.
          <br> Dolores, illo.
        </div>
       </div>
      <div class="col-md-3 col-sm-3 my-2 align-self-center">
        <div class="d-flex justify-content-center">
          <h3>+ NEW TOPIC</h3>
        </div>
      </div>
    </div>
    </div>
    <div class="row m-3 p-3 bg-white">
      <!-- <h3>Threads</h3> -->
      <div class="row align-items-center pb-2" v-for="thread in threads" :key="thread" >
        <div class="col-1 mx-0 d-flex justify-content-center" ><img src="../../../public/img/post.png" alt="post" style="max-width: 100%;"></div>
        <div class="col-10 my-3">
            <div class="row" data-bs-toggle="collapse" :data-bs-target="'#thread-'+thread.id" :aria-expanded="'thread-'+thread.id" :aria-controls="'thread-'+thread.id">
                 <p class="my-2"> <strong> {{ thread.title }} </strong> </p> <br>
                 <p class="text-justify"> {{thread.content}} </p>
            </div>
            <div class="row my-1">
                <div class="col d-flex justify-content-end ms-0 ps-0 my-2" v-for="user in thread.user" :key="user.name">
                  <label for="post" class="mx-3"></label> <img :src="user.img" class="w-25 rounded-circle mx-0 px-0" style="max-width: 5%;"><label for="post" class="me-3"></label>
                  <strong> {{user.name}}</strong> <label for="post" class="me-2"></label> |  <label for="post" class="me-2"></label> {{thread.date}}
                </div>
            </div>
            <div class="collapse row align-items-start" :id="'thread-'+thread.id" >
                <div class="col-1"> </div>
                <div class="col-11">
                  <div class="row my-2" v-for="reply in thread.responses" :key="reply">
                    {{reply.content}}
                    <span class="my-2">
                    <img :src="reply.img" class="w-25 rounded-circle mx-0 px-0" style="max-width: 5%;"><label for="reply" class="me-3"></label>
                     <label for="reply" class="me-2"> <strong> {{reply.user}} </strong></label>  <label for="reply" class="me-2">|</label> {{reply.date}} </span>
                  </div>
                  <form id="myForm" @submit.prevent="sendPost">
                    <textarea name="body" v-model="body"></textarea><br>
                    <button class="my-2 px-3">Send</button>
                  </form>
                </div>
              </div>
        </div>
        <div class="col-1 mx-0 d-flex justify-content-center" > {{thread.response_num }} <label for="resp_num" class="me-2"> </label> <i class="bi bi-chat-square-text"></i>  </div>
      </div>
    </div>
  </div>



  <div class="col-md-3 col-sm-3 my-3 bg-white" id="right-nav">     <!-- RIGHT NAV-->
    <div class="row bg-gray py-3 my-3 d-flex justify-content-center" id="right-nav-search-bar">   <!-- RIGHT NAV -SEARCH BAR -->
        <div class="row mx-5" id="search-area"> <!-- RIGHT NAV -SEARCH INPUT AREA-->
          <input type="text" class="form-control" placeholder="Search" aria-label="Search" aria-describedby="basic-addon2">
        </div>
        <div class="row mx-5" id="search-button">  <!-- RIGHT NAV - SEARCH BAR BUTTON-->
            <button type="button" class="btn btn-primary mt-2"> Search </button>
        </div>
    </div>
    <div class="row bg-gray pb-3 mb-3 d-flex justify-content-center" id="right-nav-categories">       <!-- RIGHT NAV - CATEGORIES-->
      <div class="col">
        <div class="row m-4">
          <h3>Categories</h3>
        </div>
        <div class="row ms-4">
          <ul>
            <li>All</li>
            <li>General</li>
            <li>Lessons</li>
            <li>Support</li>
          </ul>
        </div>
      </div>
    </div>
  </div>

</div>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
</template>


<script>
import axios from 'axios'


export default {
  name: "Community",
    data () {
      return {
        threads: [],
        categories: ["All",
                    "General",
                    "Lessons",
                    "Support",
                    ],
      }
  },
  methods: {
     getResponses: function () {
      {
        axios.get("/common/threads").then((response) => {
          this.threads = response.data;
          console.log(this.threads);
        });
      }
    }
  },
  beforeMount() {
    this.getResponses();
  },
  }
</script>

<style lang="scss">
</style>