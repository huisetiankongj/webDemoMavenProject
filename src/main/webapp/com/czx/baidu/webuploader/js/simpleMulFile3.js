$(function(){
	var rootPath = Svc.rootPath(),pluginPath=rootPath+"com/czx/plugin/";
	$list = $('#filelist'),
    $btn = $('#ctlBtn'),
    state = 'pending',
    uploader;
	uploader = WebUploader.create({
		
	    // swf文件路径
		 swf: pluginPath + 'webuploader/0.1.5/Uploader.swf',

	    // 文件接收服务端。
//	    server: pluginPath+'webuploader/0.1.5/server/fileupload.php',
	    server: rootPath+'baidu/webuploader/uploadFileBySpring.do',
	    // 选择文件的按钮。可选。
	    // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	    pick: '#picker',

	    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
	    resize: false
	});
	// 当有文件被添加进队列的时候
	uploader.on( 'fileQueued', function( file ) {
		
	      var $li = $( '<li id="' + file.id + '">' +
	                '<div class="title" style="margin-top:10px;height:40%;">' + file.name + '</div>' +
	                '<div class="state" style="height:20%;text-align:center;line-height: 2;">等待上传...</div>' +
	                '<div class="progress  progress-striped active "><div class="progress-bar" role="progressbar" style="width: 0%"></div></div>' +
	                '</li>' );
	      
	      $li.appendTo($list);
	});

	// 文件上传过程中创建进度条实时显示。
	uploader.on( 'uploadProgress', function( file, percentage ) {
	    var $li = $( '#'+file.id ),
	        $percent = $li.find('.progress .progress-bar');


	    $li.find('div.state').html('上传中');

	    $percent.html(percentage * 100 + '%' );
	    $percent.css( 'width', percentage * 100 + '%' );
	});

	uploader.on( 'uploadSuccess', function( file ) {
	    $( '#'+file.id ).find('div.state').text('已上传');
	});

	uploader.on( 'uploadError', function( file ) {
	    $( '#'+file.id ).find('div.state').text('上传出错');
	});

	uploader.on( 'all', function( type ) {
        if ( type === 'startUpload' ) {
            state = 'uploading';
        } else if ( type === 'stopUpload' ) {
            state = 'paused';
        } else if ( type === 'uploadFinished' ) {
            state = 'done';
        }

        if ( state === 'uploading' ) {
            $btn.text('暂停上传');
        } else {
            $btn.text('开始上传');
        }
    });

    $btn.on( 'click', function() {
        if ( state === 'uploading' ) {
            uploader.stop();
        } else {
            uploader.upload();
        }
    });
    
    $("#btn1").click(function(){
   	 uploader.stop();
   })
});