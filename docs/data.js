const board = []


const getDiscussion = () => {
  return  fetch ("http://ec2-15-165-63-80.ap-northeast-2.compute.amazonaws.com:8080/question/list?page=1&size=10")
    .then((res) => res.json())
    .then((result) => {
      console.log(result.data);
    });
};

getDiscussion()