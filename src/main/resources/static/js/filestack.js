const openBtn = document.getElementById('open');
const options = {
    onUploadDone: (res) =>
        document.getElementById("photo").value = res.filesUploaded[0].url,
};
console.log(50);
const client = filestack.init(FSKey);

openBtn.addEventListener("click", function () {
    client.picker(options).open()

});
