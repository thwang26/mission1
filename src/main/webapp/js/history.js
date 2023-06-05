function deleteHistory(id) {
    if (confirm("삭제하시겠습니까?")) {
        location.href = "http://localhost:8080/delete-history?id="+id;
    }
}