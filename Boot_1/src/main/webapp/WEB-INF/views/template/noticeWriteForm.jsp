		<form:form action="./noticeWrite" modelAttribute="noticeVO" method="post" enctype="multipart/form-data">
			<div class="form-group">
     			<label for="id">title:</label>
     			<form:input path="title" class="form-control" id="title" placeholder="Enter title"/>
   				<form:errors path="title"/>
   			</div>
			<div class="form-group">
      			<label for="writer">writer:</label>
      			<form:input path="writer" class="form-control" id="writer" value="${member.id}"/>
    			<form:errors path="writer"/>
    		</div>
    		<div class="form-group">
      			<label for="contents">contents:</label>
      			<form:textarea path="contents" class="form-control" id="contents" placeholder="Enter Contents"/>
    			<form:errors path="contents"/>
    		</div>
    		<div class="form-group">
     			<label for="files">file:</label>
      			<input type="file" class="form-control" id="files" name="files">
    		</div>
    		
    		<button type="submit" class="btn btn-default">Submit</button>
		</form:form>