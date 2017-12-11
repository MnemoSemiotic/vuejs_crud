<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view/>
    <div class="row">

      <div class="col-xs-12 col-sm-8 col-sm-offset-2 col-md-6 col-md-offset-3">
        <h1>Add a New Flashcard</h1>
        <div class="form-group">
          <label>Question</label>
          <input class="form-control" type="text" v-model="flashcard.question">
        </div>
        <div class="form-group">
          <label>Answer</label>
          <input class="form-control" type="text" v-model="flashcard.answer">
        </div>
        <button class="btn btn-primary" @click="submit">Submit</button>
        <hr>


        <h1>Get A Flashcard</h1>
        <div class="form-group">
          <label>ID of Flashcard</label>
          <input class="form-control" type="text" v-model="flashcard.id">
        </div>
        <button class="btn btn-primary" @click="fetchOne">Get that Card</button>

          <p>Id: {{ oneFlashcard.id }} - Question: {{ oneFlashcard.question }} <br>

            Answer: {{ oneFlashcard.answer }}
          </p>
        <hr>

        <h1>Update A Flashcard</h1>
        <div class="form-group">
          <label>ID of Flashcard</label>
          <input class="form-control" type="text" v-model="flashcardUpdate.id">
        </div>
        <div class="form-group">
          <label>Question</label>
          <input class="form-control" type="text" v-model="flashcardUpdate.question">
        </div>
        <div class="form-group">
          <label>Answer</label>
          <input class="form-control" type="text" v-model="flashcardUpdate.answer">
        </div>
        <button class="btn btn-primary" @click="update">Update that Card</button>

        <hr>

        <h1>Delete A Flashcard</h1>
        <div class="form-group">
          <label>ID of Flashcard</label>
          <input class="form-control" type="text" v-model="flashcardDelete.id">
        </div>
        <button class="btn btn-primary" @click="deleteCard">Delete that Card</button>
        <hr>



        <h1>List All Flashcards</h1>
        <button class="btn btn-primary" @click="fetchData">List All Flashcards</button>
        <ul class="list-group">
          <li class="list-group-item" v-for="f in flashcards">{{ f.id }} : {{ f.question }} : {{ f.answer }} </li>
        </ul>


        </div>
      </div>

  </div>

</template>

<script>
export default {
  data() {
    return {
      flashcard: {
        question: '',
        answer: '',
        id: ''
      },
      oneFlashcard: {
        question: '',
        answer: '',
        id: ''
      },

      flashcardUpdate: {
        question: '',
        answer: '',
        id: ''
      },
      flashcardDelete: {
        id: ''
      },

      flashcards: []
    };
  },
  methods: {
    submit() {
      this.$http.post('http://localhost:8080/flashcards/addflashcard' + '?flashCardQuestion=' + this.flashcard.question + '?&flashCardAnswer=' + this.flashcard.answer )
          .then( response => {
            console.log(response);
          }, error => {
            console.log(error);
          });
    },

    update() {
      this.$http.get('http://localhost:8080/flashcards/updateflashcard/' + this.flashcardUpdate.id + '?question=' + this.flashcardUpdate.question + '?&answer=' + this.flashcardUpdate.answer )
          .then(response => {
          console.log(response);
        }, error => {
          console.log(error);
        });
    },

    fetchOne() {
      console.log("flashcardId:" + this.flashcard.id);
      this.$http.get('http://localhost:8080/flashcards/' + this.flashcard.id)
          .then(response => {
            return response.json();
          })
          .then(data => {
            const resultArray = [];
            for (let key in data) {
              resultArray.push(data[key]);
            }
            this.oneFlashcard.id = resultArray[0];
            this.oneFlashcard.question = resultArray[1];
            this.oneFlashcard.answer = resultArray[2];
          });
    },

    fetchData() {
      this.$http.get('http://localhost:8080/flashcards/')
          .then(response => {
            return response.json();
          })
          .then(data => {
            const resultArray = [];
            for (let key in data) {
              console.log("data:" + key);

              resultArray.push(data[key]);
            }
            this.flashcards = resultArray;
            console.log(this.flashcards);
          });
    },

    deleteCard() {
      console.log("deleteId: " + this.flashcardDelete.id);
      this.$http.get('http://localhost:8080/flashcards/deleteflashcard/' + this.flashcardDelete.id )
          .then(response => {
          console.log(response);
        }, error => {
          console.log(error);
        });
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
